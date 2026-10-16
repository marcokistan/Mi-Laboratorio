"""

CALCULADORA IEEE-754, creada por marcokistan, 2026
v1.0

Puede convertir cualquier numero decimal/hexadecimal a formato IEEE-754 y realizar la operación
contraria.

Además, es capaz de detectar y solucionar casos especiales, como numeros subnormales... NaN... y infinitos
(overflow por 32 bits).


"""

# libreria para trabajar con bytes
import struct
# variable que mantiene el programa encendido
running = True

def binaryconversion(entry):
    # usamos la libreria struct para obtener el formato IEEE754 instantaneamente
    # en grupos de bytes. Un for en el objeto bytes hace que cada iterado sea un grupo de bytes.
    simple_precision = ""
    bytes_ieee = struct.pack('!f', entry) 
    for byte in bytes_ieee:
        simple_precision += f'{byte:08b}'
    return simple_precision

def decimalconversion(entry):
    #declaración de variables
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
    potencias_a_multiplicar_exponente = []
    for bit in cadena_raw_exponente:
        contador_pos -= 1
        if bit == "1":
            potencias_a_multiplicar_exponente.append(contador_pos)
    # si no hay objetos en la lista, asumimos inmediatamente que se trata de un caso especial matematico
    if potencias_a_multiplicar_exponente == []:
        exponente = 2 ** -126
    else:
        exponente_sin_sesgo = 0
        for potencia in potencias_a_multiplicar_exponente:
            potencia = 2 ** potencia
            exponente_sin_sesgo += potencia
        exponente = exponente_sin_sesgo - 127
    # obtener mantisa
    cadena_raw_mantisa = entry[9:]
    potencias_a_multiplicar_mantisa = []
    contador_pos = 0
    for bit in cadena_raw_mantisa:
        contador_pos -= 1
        if bit == "1":
            potencias_a_multiplicar_mantisa.append(contador_pos)
    mantisa = 0
    for potencia in potencias_a_multiplicar_mantisa:
        potencia = 2 ** potencia
        mantisa += potencia
    # calculo final

    # comprobación para casos de subnormales y infinitos
    if mantisa == 0 and exponente == 2 ** -126:
        return 0.0 * signo
    elif exponente == 2 ** -126:
        return signo * mantisa * exponente
    elif len(potencias_a_multiplicar_exponente) == 8 and len(potencias_a_multiplicar_mantisa) > 0:
        print("CASO NaN, no es un número.")
        return 0
    elif len(potencias_a_multiplicar_exponente) == 8 and len(potencias_a_multiplicar_mantisa) == 0:
        print("CASO Infinito, este numero es infinito o no cabe en representación de 32 bits")
        return 0
    # comprobación caso normal
    else:
        resultado = signo * (2 ** exponente) * (mantisa + 1)
        return resultado


# Programa principal, escucha el input del usuario.

def program():
    global running
    print("---CALCULADORA IEEE-754, ESCRIBA /h PARA OBTENER LA LISTA DE COMANDOS---\n")
    while running == True:
        try:
            command = input("IEEE-754 CALC: ")
            # comando help
            if command == "/h" or command == "/H":
                print("LISTA DE COMANDOS:\n"
                "/P : CONVIERTE UN NUMERO A REPRESENTACIÓN IEEE 754\n"
                "/D : CONVIERTE UN NUMERO EN REPRESENTACIÓN IEEE 754 A DECIMAL\n"
                "/H : OBTIENE LA LISTA DE COMANDOS DE LA APLICACIÓN\n"
                "/Q : CIERRA EL PROGRAMA\n\n" 
                "El programa permite representaciones binarias y hexadecimales.\n"
                "Software creado por marcokistan 2026")
            # comando conversion a IEEE754
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
                print(f"RESULATADO EN FORMATO IEE-754 (Bin): {binario}\nRESULATADO EN FORMATO IEE-754 (Hex): {f"{int(binario, 2):08x}"}")
            # comando conversión a DECIMAL/HEX
            if command == "/d" or command == "/D":
                entry = input("Introduzca un numero con representacion IEEE 754: ")
                # caso hexadecimal
                if len(entry) == 8:
                    for caracter in entry:
                        if caracter not in "0123456789abcdefABCDEF":
                            raise ValueError
                    entry = f"{int(entry, 16):032b}"
                else:
                    if len(entry) != 32:
                        raise ValueError
                    for caracter in entry:
                        if caracter != "1" and caracter != "0":
                            raise ValueError
                decimal = decimalconversion(entry)
                print(f"RESULATADO EN FORMATO DECIMAL: {decimal}\nRESULATADO EN FORMATO HEXADECIMAL: {int(binaryconversion(decimal), 2):08x}")
            # comando que cierra el programa
            if command == "/q" or command == "/Q":
                running = False
        except:
            print("Entrada no valida")

program()

