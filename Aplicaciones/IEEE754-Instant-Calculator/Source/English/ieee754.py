"""
IEEE-754 CALCULATOR, created by marcokistan, 2026
v1.0

It can convert any decimal/hexadecimal number to IEEE-754 format
and perform the reverse operation.

It can also detect and handle special cases, such as subnormal numbers,
NaN, and infinities (32-bit overflow).
"""

# Library for working with bytes
import struct

# Variable that keeps the program running
running = True


def binary_conversion(number):
    # Use the struct library to obtain the IEEE-754 representation
    # in groups of bytes. Iterating over a bytes object returns one byte at a time.
    single_precision = ""
    ieee_bytes = struct.pack('!f', number)

    for byte in ieee_bytes:
        single_precision += f'{byte:08b}'

    return single_precision


def decimal_conversion(binary_entry):
    # Variable declarations
    exponent = 0
    sign = 0
    mantissa = 0

    # Obtain the sign
    if binary_entry[0] == "1":
        sign = -1
    else:
        sign = 1

    # Obtain the exponent
    position_counter = 8
    raw_exponent_string = binary_entry[1:9]  # Bits 1 through 8
    exponent_powers = []

    for bit in raw_exponent_string:
        position_counter -= 1

        if bit == "1":
            exponent_powers.append(position_counter)

    # If the list is empty, assume that this is a special mathematical case
    if exponent_powers == []:
        exponent = 2 ** -126
    else:
        unbiased_exponent = 0

        for power in exponent_powers:
            power = 2 ** power
            unbiased_exponent += power

        exponent = unbiased_exponent - 127

    # Obtain the mantissa
    raw_mantissa_string = binary_entry[9:]
    mantissa_powers = []
    position_counter = 0

    for bit in raw_mantissa_string:
        position_counter -= 1

        if bit == "1":
            mantissa_powers.append(position_counter)

    mantissa = 0

    for power in mantissa_powers:
        power = 2 ** power
        mantissa += power

    # Final calculation

    # Check for subnormal numbers and infinities
    if mantissa == 0 and exponent == 2 ** -126:
        return 0.0 * sign

    elif exponent == 2 ** -126:
        return sign * mantissa * exponent

    elif len(exponent_powers) == 8 and len(mantissa_powers) > 0:
        print("NaN CASE: This is not a number.")
        return 0

    elif len(exponent_powers) == 8 and len(mantissa_powers) == 0:
        print(
            "INFINITY CASE: This number is infinite or "
            "cannot be represented in 32-bit format."
        )
        return 0

    # Check the normal case
    else:
        result = sign * (2 ** exponent) * (mantissa + 1)
        return result


# Main program: waits for user input

def program():
    global running

    print(
        "--- IEEE-754 CALCULATOR, TYPE /h TO VIEW THE COMMAND LIST ---\n"
    )

    while running == True:
        try:
            command = input("IEEE-754 CALC: ")

            # Help command
            if command == "/h" or command == "/H":
                print(
                    "COMMAND LIST:\n"
                    "/P : CONVERTS A NUMBER TO IEEE-754 REPRESENTATION\n"
                    "/D : CONVERTS AN IEEE-754 NUMBER TO DECIMAL\n"
                    "/H : DISPLAYS THE APPLICATION COMMAND LIST\n"
                    "/Q : CLOSES THE PROGRAM\n\n"
                    "The program supports binary and hexadecimal representations.\n"
                    "Software created by marcokistan, 2026"
                )

            # Convert to IEEE-754
            if command == "/p" or command == "/P":
                floating_number = ""

                entry = input(
                    "Enter a decimal number (use a dot or comma to indicate "
                    "the end of the integer part): "
                )

                for character in entry:
                    if character == ",":
                        floating_number += "."
                    else:
                        floating_number += character

                floating_number = float(floating_number)

                binary = binary_conversion(floating_number)
                hexadecimal = f"{int(binary, 2):08x}"

                print(
                    f"RESULT IN IEEE-754 FORMAT (Binary): {binary}\n"
                    f"RESULT IN IEEE-754 FORMAT (Hexadecimal): {hexadecimal}"
                )

            # Convert from IEEE-754 to decimal/hexadecimal
            if command == "/d" or command == "/D":
                entry = input(
                    "Enter a number in IEEE-754 representation: "
                )

                # Hexadecimal case
                if len(entry) == 8:
                    for character in entry:
                        if character not in "0123456789abcdefABCDEF":
                            raise ValueError

                    entry = f"{int(entry, 16):032b}"

                else:
                    if len(entry) != 32:
                        raise ValueError

                    for character in entry:
                        if character != "1" and character != "0":
                            raise ValueError

                decimal = decimal_conversion(entry)

                hexadecimal = f"{int(binary_conversion(decimal), 2):08x}"

                print(
                    f"RESULT IN DECIMAL FORMAT: {decimal}\n"
                    f"RESULT IN HEXADECIMAL FORMAT: {hexadecimal}"
                )

            # Command to close the program
            if command == "/q" or command == "/Q":
                running = False

        except:
            print("Invalid input.")


program()