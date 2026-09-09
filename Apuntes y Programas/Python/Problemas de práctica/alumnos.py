DictDeAlumnos = {}
DictDeMedias = {}

# Ajustes del programa
numero_de_notas = 3
encendido = True


def calcular_la_media(Alumno, nombre):
     acumulador = 0
     numero_de_iteraciones = 0
     lista_auxiliar_notas = []
     for notas in Alumno:
          acumulador += notas
          numero_de_iteraciones += 1
     acumulador = acumulador / numero_de_iteraciones
     DictDeMedias[nombre] = acumulador
     print(f"La media del alumno {nombre} es {acumulador}")
     if acumulador < 5:
          print("El alumno ha suspenso")
     else:
          print("El alumno ha aprobado")
     print("-----MEDIAS-----")
     for alumno in DictDeMedias:
         print(f"{alumno} -> {DictDeMedias[alumno]}")
         lista_auxiliar_notas.append(DictDeMedias[alumno])
     lista_ordenada = sorted(lista_auxiliar_notas)
     for alumno in DictDeMedias:
         if DictDeMedias[alumno] == lista_ordenada[-1]:
             print(f"El alumno con la mayor media es {alumno}")
             break

def agendar():
    lista_de_notas = []
    numero_de_iteraciones = 0
    nombre_del_usuario = input("Introduzca el nombre del usuario: ")
    while numero_de_iteraciones != numero_de_notas:
        try:
            nota_del_usuario = float(input("Introduzca una nota: "))
            if nota_del_usuario > 10 or nota_del_usuario < 0:
                raise ValueError
            lista_de_notas.append(nota_del_usuario)
            numero_de_iteraciones += 1
        except:
            print("Esa nota es invalida, por favor introduzca una nota numerica valida")
    DictDeAlumnos[nombre_del_usuario] = lista_de_notas
    calcular_la_media(DictDeAlumnos[nombre_del_usuario], nombre_del_usuario)

while encendido == True:
    comando = input("Desea agendar un usuario? (si/no): ")
    if comando != "si" and comando != "no":
        print("Escriba si o no...")
    else:
        if comando == "si":
            agendar()
        else:
            encendido = False
        

    