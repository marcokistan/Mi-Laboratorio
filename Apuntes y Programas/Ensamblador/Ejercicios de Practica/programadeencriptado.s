# Problema de examen ensamblador, debemos buscar en una cadena de texto, que solo
# tiene letras minusculas y espacios, convertir en mayusculas todas las palabras, eliminar los especios y sustituir un caracter especifico por otro, ademas debemos contar
# cuantas veces reemplezamos

.data
    cadena_entrada: .asciiz"" #Insertar cadena MANUALMENTE AQUI, recuerda, solo palabras en minusculas y espacios
    cadena_salida: .space 100
    caracter_buscar: .byte 'a'
    caracter_reemplazar: .byte '#'
    contador_reemplazadas: .word 0
.text
main:
    # primero cargamos todo en registros
    la $s0, cadena_entrada
    la $s1, cadena_salida
    lbu $s2, caracter_buscar
    lbu $s3, caracter_reemplazar
    lw $s4, contador_reemplazadas
    # convertir primera letra en mayuscula si no es espacio. El algoritmo no puede ver que hay detras del primer caracter de una cadena
    # asi que hay que forzar su conversión.
    lbu $t0, 0($s0)
    bne $t0, ' ', convertir_primera_letra
    # bucle conversor
    j bucle_encontrador_palabras
    
convertir_primera_letra:
    lbu $t0, 0($s0)
    addi $t0, $t0, -32
    sb $t0, 0($s1)
    addi $s0, $s0, 1
    addi $s1, $s1, 1
    j bucle_encontrador_palabras
    
bucle_encontrador_palabras:
    # registro $s5, será usado para el caracter final a añadir en cadena_salida.
    lbu $t0, 0($s0)
    # si es espacio, pues nada
    beq $t0, ' ', nada
    # si la cadena se acaba, cerramos el programa. las comprobaciones de finalizacion de linea se deberian hacer por buena practica, antes
    # de cualquier otra, evitará fallos en el 100% de los casos.
    beq $t0, $zero, cerrar
    # si es caracter, entonces...
    # 1, comprobar si es el caracter que queremos
    beq $t0, $s2, caracter_buscado
    # 2, comprobar si es capitalino, comprobando si el caracter anterior es un espacio
    addi $s0, $s0, -1
    lbu $t2, 0($s0)
    addi $s0, $s0, 1
    beq $t2, ' ', capitalizar
    # 3, si no es nada de lo anterior, simplemente añadimos el caracter y punto.
    move $s5, $t0
    j anadir
    
    
nada:
    addi $s0, $s0, 1
    j bucle_encontrador_palabras
    
anadir:
    sb $s5, 0($s1)
    addi $s1, $s1, 1
    addi $s0, $s0, 1
    j bucle_encontrador_palabras
    
capitalizar:
    lbu $t0, 0($s0)
    move $t3, $t0
    addi $t3, $t3, -32
    move $s5, $t3
    j anadir
    
caracter_buscado:
    move $s5, $s3
    addi $s4, $s4, 1
    j anadir
    
cerrar:
    # completamos la cadena añadiendo el fin de linea.
    sb $zero, 0($s1)  
    la $a0, cadena_salida
    li $v0, 4
    syscall
    li $v0, 10
    syscall
    
    
    
    
    
