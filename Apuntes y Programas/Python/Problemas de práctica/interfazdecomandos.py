# se enciende el programa

running = True
comando = ''

print("INTERFAZ DE COMANDOS\n/hola\n/suma\n/printing\nexit\n...")

while running == True:
    # esperamos un comando.
    while comando == '':
        comando = input(">: ")

    if comando == "/hola":
        print("hola mundo")
        
    if comando == "/suma":
        a = 0 # sumando
        b = 0 # sumando
        c = 0 # resultado
        # vamos a usar excepciones por si acaso alguien mete una letra en vez
        # de un numero.
        try:
            a = input("Introduce un número: ")
            # lo convertimos a número
            a = int(a)
            b = input("Introduce un número: ")
            # lo convertimos a número
            b = int(b)
            c = a + b
            print(f"El resultado de la suma es {c}")
        except:
            print("Alguno de los valores no es un número... vuelve a intentarlo")

    if comando == "/printing":
        mensaje_a_imprimir = input("Imprimimos el mensaje que tu pongas: ")
        print(mensaje_a_imprimir)
    if comando == "/exit":
        print("Apagando interfaz...")
        running = False

    comando = '' #reiniciamos comando a vacio para ejecutar bucle while de arriba
    # de nuevo, si no hicieramos esto, el programa todavia tendria guardado el
    # comando que enviamos antes, y ejecutaria infinitas veces el comando.


