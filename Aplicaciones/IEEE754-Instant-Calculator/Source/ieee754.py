import struct

running = True
entry = ""

def binaryconversion(entry):
    simple_precision = ""
    bytes_ieee = struct.pack('!f', entry) 
    for byte in bytes_ieee:
        simple_precision += f'{byte:08b}'
    return simple_precision
    

            


def program():
    global running, entry
    while running == True:
        try:
            floating_number = ""
            entry = input("Introduzca un numero decimal (Añada un punto o una coma para\nindicar cuando termina la parte entera): ")
            for caracter in entry:
                if caracter == ",":
                    floating_number += "."
                else:
                    floating_number += caracter
            floating_number = float(floating_number)
            binario = binaryconversion(floating_number)
        except:
            print("Entrada no valida")


program()

