def recursividad(x):
    # caso base, el argumento es igual a una lista vacia.
    if x == []:
        pass
    else:
        print(x[0])
        lista_auxiliar = []
        # incluimos todos los valores que no sean el primero en una lista nueva
        for elemento in x:
            if elemento == x[0]:
                pass
            else:
                lista_auxiliar.append(elemento)
        # terminamos el recorte llamando a recursividad
        recursividad(lista_auxiliar)

recursividad() # poner la lista aqui
