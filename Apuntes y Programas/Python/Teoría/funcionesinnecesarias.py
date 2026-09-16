# Informatica
# Documento de funciones innecesarias que aún así necesito aprender.

# 1.) ENUMERATE

# Enumerate imprime el indice y el valor actual del iterado. Requiere de dos valores.
def enumeratetest(x):
    for indx, value in enumerate(x):
        print(indx, value)

# a enumerate se le puede añadir un segundo parametro que es el indice de donde empezar a enumerar en una secuencia dada.

enumeratetest(["manzana", "pera", "aguacate"])


# 2.) LIST.CLEAR()    

#En Python, list.clear() es un método de listas que se utiliza para eliminar todos los elementos de la lista, dejándola vacía.

list1 = [1,2,3,4]
print(list1)
list1.clear() # no acepta parametros, limpia todo.
print(list1)

# 3.) TYPE()

# Type no es innecesaria, es muy útil, sin embargo necesito aprenderla, asi que la anotaré aquí

# Type nos permite saber que tipo de cosa es algo, muy útil para filtrar.

tuple1 = (1,2,3,"hola",True)
numrandom = 0
#imaginemos que queremos filtrar ints y sumarlas.

for item in tuple1:
    if type(item) is int:
        numrandom = numrandom + item
    else:
        pass

print(numrandom)

# 4.) ANY()

# Any devuelve True si alguna condición de dentro es true, le puedes añadir un bucle for dentro para iterar

tuple2 = ("carlos","pedro")
if any(item == "carlos" for item in tuple2) == True: #comprueba directamente si item == "carlos", no es necesario añadir "if".
    print("true")

# 5.) sorted()

# Sorted ordena los elementos de una lista de menor a mayor, lo que nos permite tener el valor MENOR de una lista buscando en el indice [0] y el mayor buscando en el indice [1]

list = [1,2,6,9,3,0,4]
listbutsorted = sorted(list) # 0,1,2,3,4,6,9

# 6.) Find() y Index()

#Ambos hacen la misma función pero find solo sirve para strings, index es capaz de devolver el indice de un elemento equivalente en la lista/tupla que le insertes dentro de los parentesis.

stringparafind = ("hola mundo")
valorparaencontrar = stringparafind.find("mundo") #5, a partir del 6 empieza el primer caracter de mundo

listarandom = [1,2,3,4,5,6]
valorenindice = listarandom.index(4) # 3

# 7.) lower()

#Lower puede convertir todos los caracteres de una string en minuscula, es muy util cuando el algoritmo te pide
# ignorar las mayusculas, para obtener el texto en crudo.


string_con_mayusculas = "Desgraciados, WowoWowoW"

string_convertida = string_con_mayusculas.lower()

print(string_convertida) # devolvera el texto todo en minuscula.


# 8.) min y max

# Ambas pueden ser usadas para devolver menor/mayor elemento en una lista. Pero ojo, no solo afecta a numeros.
# Tambien puede ordenar cadenas de texto alfabeticamente.

lista_con_palabras = ["avion", "casa", "azul"]
lista_con_numeros_ejemplo = [1, 2, 4, 9, 7]

print(min(lista_con_palabras))
print(min(lista_con_numeros_ejemplo))

# 9.) split()

# Split sirve para crear una lista, cuyos elementos son strings hijos de una string padre. Split corta cada palabra
# y la añade a la lista.

texto_para_splittear = "Hola como estas"
texto_spliteado = texto_para_splittear.split()
print(texto_spliteado)
