running = True
entry = ""

def binaryconversion(entry):
    complete = ""
    decimal = "0."
    contador = 0
    #
    cociente = 0
    resto = 0
    binario = ""
    
    if "." in entry or "," in entry:
        for entero in entry:
            if entero != "," and entero != ".":
                complete = complete + entero
            else:
                break # se ha terminado de buscar
            contador += 1
        contador += 1
        while contador != len(entry):
            decimal = decimal + entry[contador]
            contador += 1
        # --------------------------
        contador = 0
        cociente = int(complete)
        binario_reversed = []
        while cociente > 1:
            cociente_en_calculo = cociente // 2
            resto = cociente % 2
            binario_reversed.append(str(resto))
            cociente = cociente_en_calculo
        cociente_en_calculo = cociente // 2
        resto = cociente % 2
        binario_reversed.append(str(resto))
        cociente = cociente_en_calculo
        binario_reversed.reverse()
        for numero_binario in binario_reversed:
            binario = binario + numero_binario
        # normalizamos el decimal a partir de aqui con un punto, y añadimos el punto ya que este
        # es el caso decimal
        binario = binario + "."
        contador = 0
        decimal = float(decimal)
        while decimal > 0:
            decimal = decimal * 2
            binario = binario + str(decimal)[0]
            # vamos a clonar
            decimal_clon = "0."
            decimal = str(decimal)
            for valor in decimal:
                if contador == 0 or valor == ".":
                    pass
                else:
                    if contador == len(decimal) - 1:
                        if valor == "0":
                            pass
                        else:
                            decimal_clon = decimal_clon + valor
                    else:
                        decimal_clon = decimal_clon + valor
                contador += 1
            decimal = decimal_clon
            decimal = float(decimal)
    else:
        for entero in entry:
            if entero != "," or entero != ".":
                complete = complete + entero
            else:
                break # se ha terminado de buscar
        cociente = int(complete)
        binario_reversed = []
        while cociente > 1:
            cociente_en_calculo = cociente // 2
            resto = cociente % 2
            binario_reversed.append(str(resto))
            cociente = cociente_en_calculo
        cociente_en_calculo = cociente // 2
        resto = cociente % 2
        binario_reversed.append(str(resto))
        cociente = cociente_en_calculo
        binario_reversed.reverse()
        for numero_binario in binario_reversed:
            binario = binario + numero_binario

    return binario

            

        
       

        


def program():
    global running, entry
    while running == True:
        only_one_comma = False
        try:
            entry = input("Introduzca un numero decimal (Añada un punto o una coma para\nindicar cuando termina la parte entera): ")
            for valor in entry:
                if valor.isalpha():
                    raise ValueError
                if (valor == "," or valor == ".") and only_one_comma == False:
                    only_one_comma = True
                else:
                    if valor.isdigit():
                        pass
                    else:
                        raise ValueError
            print(f"Debug: {entry}")
            binario = binaryconversion(entry)
            print(f"Debug: {binario}")
        except:
            print("Entrada no valida")


program()

