texto_passed = False
while texto_passed == False:
    try:
        texto_raw = input("Introduzca un texto por favor: ")
        if texto_raw == "":
            raise ValueError
        else:
            texto_passed = True
    except:
        print("Ha de introducir un texto... Por favor vuelva a intentarlo")
texto_sin_caps = texto_raw.lower()
palabras_prohibidas = [".", ",", ":", ";", "!", "¡", "!", "?", "¿"]
palabras_finales = []
diccionario_palabras = {}
diccionario_ordenado = {}
lista_de_repeticiones = []
lista_de_coincidencias = []
texto_final = []
numero_de_letras = [0]
palabras_finales = texto_sin_caps.split()
for palabra in palabras_finales:
    palabra_molde = ""
    if palabra in palabras_prohibidas or len(palabra) == 1:
        pass
    else:
        for letra in palabra:
            if letra in palabras_prohibidas:
                if len(palabra) > 2:
                    texto_final.append(palabra_molde)
                palabra_molde = ""
            else:
                palabra_molde = palabra_molde + letra
        texto_final.append(palabra_molde)
for palabra in texto_final:
    if palabra == "":
        pass
    else:
        if palabra in diccionario_palabras:
            diccionario_palabras[palabra] += 1
        else:
            diccionario_palabras[palabra] = 1
for palabra in diccionario_palabras:
    lista_de_repeticiones.append(diccionario_palabras[palabra])
lista_de_repeticiones = sorted(lista_de_repeticiones)
while len(lista_de_repeticiones) > 0:
    lista_de_coincidencias = []
    if len(lista_de_repeticiones) > 1:
        if lista_de_repeticiones[-1] != lista_de_repeticiones[-2]:
            for palabra in diccionario_palabras:
                if diccionario_palabras[palabra] == lista_de_repeticiones[-1]:
                    diccionario_ordenado[palabra] = diccionario_palabras[palabra]
            del lista_de_repeticiones[-1]
        else:
            for palabra in diccionario_palabras:
                if diccionario_palabras[palabra] == lista_de_repeticiones[-1]:
                    lista_de_coincidencias.append(palabra)
            while len(lista_de_coincidencias) > 0:
                palabra_alfabetica = min(lista_de_coincidencias)
                for palabra in diccionario_palabras:
                    if palabra == palabra_alfabetica:
                        diccionario_ordenado[palabra] = diccionario_palabras[palabra]
                lista_de_coincidencias.remove(palabra_alfabetica)
                del lista_de_repeticiones[-1]
    else:
        for palabra in diccionario_palabras:
            diccionario_ordenado[palabra] = diccionario_palabras[palabra]
        del lista_de_repeticiones[0]
# En teoria ya esta, ahora podemos imprimir
contador_ranking = 1
contador_de_palabras = 0
for palabra in diccionario_ordenado:
    print(f"{contador_ranking}: {palabra} -> {diccionario_ordenado[palabra]}")
    contador_de_palabras += diccionario_ordenado[palabra]
    contador_ranking += 1
print(f"Numero de palabras total: {contador_de_palabras}\nNumero de palabras diferentes: {contador_ranking - 1}")
total_de_letras = 0
for palabra in diccionario_ordenado:
    total_de_letras += len(palabra)
    numero_de_letras.append(len(palabra))
numero_de_letras = sorted(numero_de_letras)
if len(numero_de_letras) == 0:
    pass
else:
    media_longitud = total_de_letras // len(numero_de_letras) - 1
palabras_largas = []
cadena_con_palabras_largas = ""
for palabra in diccionario_ordenado:
    if len(palabra) == numero_de_letras[-1]:
        palabras_largas.append(palabra)
if len(palabras_largas) == 1:
    cadena_con_palabras_largas = palabras_largas[0]
else:
    while len(palabras_largas) > 0:
        cadena_con_palabras_largas = cadena_con_palabras_largas + palabras_largas[0]
        del palabras_largas[0]
        if len(palabras_largas) > 0:
            cadena_con_palabras_largas = cadena_con_palabras_largas + " y "
print(f"La palabra/s mas larga es {cadena_con_palabras_largas} con {numero_de_letras[-1]} letras\nLa media de longitud de las palabras es de {media_longitud}")

            





