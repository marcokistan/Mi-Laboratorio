import struct

running = True
hex_list = ["0", "1", "2,", "3", "4", "5", "6", "7", "8", "9",
            "a", "A", "b", "B", "c", "C", "d", "D", "e", "E", "f", "F"]


def binaryconversion(entry):
    simple_precision = ""
    bytes_ieee = struct.pack('!f', entry) 
    for byte in bytes_ieee:
        simple_precision += f'{byte:08b}'
    return simple_precision

def decimalconversion(entry):
    exponente = 0
    signo = 0
    mantisa = 0
    # obtener signo
    if entry[0] == "1":
        signo = -1
    else:
        signo = 1
    # obtener exponente
    contador_pos = 8
    cadena_raw_exponente = entry[1:9] # bits del 1 al 8
    potencias_a_multiplicar = []
    for bit in cadena_raw_exponente:
        contador_pos -= 1
        if bit == "1":
            potencias_a_multiplicar.append(contador_pos)
    exponente_sin_sesgo = 0
    for potencia in potencias_a_multiplicar:
        potencia = 2 ** potencia
        exponente_sin_sesgo += potencia
    exponente = exponente_sin_sesgo - 127
    # obtener mantisa
    cadena_raw_mantisa = entry[9:]
    potencias_a_multiplicar = []
    contador_pos = 0
    for bit in cadena_raw_mantisa:
        contador_pos -= 1
        if bit == "1":
            potencias_a_multiplicar.append(contador_pos)
    mantisa = 0
    for potencia in potencias_a_multiplicar:
        potencia = 2 ** potencia
        mantisa += potencia
    # calculo final
    resultado = signo * (2 ** exponente) * (mantisa + 1)
    return resultado


def program():
    global running, hex_list
    print("---CALCULADORA IEEE-754, ESCRIBA /h PARA OBTENER LA LISTA DE COMANDOS---\n")
    while running == True:
        try:
            command = input("IEEE-754 CALC: ")
            if command == "/h" or command == "/H":
                print("LISTA DE COMANDOS:\n"
                "/P : CONVIERTE UN NUMERO A REPRESENTACIÓN IEEE 754\n"
                "/D : CONVIERTE UN NUMERO EN REPRESENTACIÓN IEEE 754 A DECIMAL\n"
                "/H : OBTIENE LA LISTA DE COMANDOS DE LA APLICACIÓN\n"
                "/Q : CIERRA EL PROGRAMA\n\n" 
                "El programa permite representaciones binarias y hexadecimales.\n"
                "Software creado por marcokistan 2026")
            if command == "/p" or command == "/P":
                floating_number = ""
                entry = input("Introduzca un numero decimal (Añada un punto o una coma para\nindicar cuando termina la parte entera): ")
                for caracter in entry:
                    if caracter == ",":
                        floating_number += "."
                    else:
                        floating_number += caracter
                floating_number = float(floating_number)
                binario = binaryconversion(floating_number)
                print(f"RESULATADO EN FORMATO IEE-754 (Bin): {binario}\nRESULATADO EN FORMATO IEE-754 (Hex): {hex(int(binario, 2))[2:]}")
            if command == "/d" or command == "/D":
                entry = input("Introduzca un numero con representacion IEEE 754: ")
                # caso hexadecimal
                if len(entry) == 8:
                    for caracter in entry:
                        if caracter not in hex_list:
                            raise ValueError
                    entry = f"{int(entry, 16):032b}"
                else:
                    if len(entry) != 32:
                        raise ValueError
                    for caracter in entry:
                        if caracter != "1" and caracter != "0":
                            raise ValueError
                decimal = decimalconversion(entry)
                print(decimal)
            if command == "/q" or command == "/Q":
                running = False
        except:
            print("Entrada no valida")

program()

