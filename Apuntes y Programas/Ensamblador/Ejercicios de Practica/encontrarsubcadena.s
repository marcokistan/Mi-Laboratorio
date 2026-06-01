.data
    linea1: .asciiz"Tres, Tres,tristes tigres, tresco, trescas, tres, tres, Tres, Tres"
    linea2: .asciiz"Tres, Tres"
    asterisco: .asciiz"*"
.text
main:
    # EJERCICIO DE EXAMEN, BASICAMENTE ESE DEBE ENCONTRAR LA SUBCADENA EN LA CADENA PRINCIPAL, Y CUANDO OCURRA PONER UN ASTERISCO EN EL PRIMER CARACTER.
    
    la $s0, linea2 #contiene adress linea 2
    la $s3, linea1 # contiene adress linea 1
    li $s1, 0 #numero de caracteres linea 2
    li $s2, 10 #constante 10
    li $s4, 0 #contador iteraciones
    jal contador_caracteres
    # reseteamos registro $s0
    move $s0, $zero
    la $s0, linea2
    lbu $s7, ($s0) #primer caracter linea 2
    j bucle_buscador_primer_caracter
contador_caracteres:
    addi $sp, $sp, -4
    sw $ra, 0($sp)
    lbu $t0, ($s0)
    beq $t0, $zero, fin_cuenta #al final cuando encuentre new line para.
    addi $s1, $s1, 1
    addi $s0, $s0, 1
    jal contador_caracteres
    addi $sp, $sp, 4
    lw $ra, 0($sp)
    jr $ra
fin_cuenta:
    jr $ra
bucle_buscador_primer_caracter:
    # reseteamos registro $s0
    move $s0, $zero
    la $s0, linea2
    li $s4, 0
    lbu $t1, ($s3)
    move $s5, $t1 #ultimo caracter analizado
    beq $t1, $s7, primercaracterencontrado
    move $a0, $s5
    li $v0, 11
    syscall
    beq $zero, $t1, se_acabo
    addi $s3, $s3, 1
    j bucle_buscador_primer_caracter
primercaracterencontrado:
    lbu $t1, ($s3)
    lbu $t0, ($s0)
    beq $s4, $s1, encontrada
    bne $t1, $t0, fallida
    addi $s3, $s3, 1
    addi $s0, $s0, 1
    addi $s4, $s4, 1
    j primercaracterencontrado
    
encontrada:
    #debemos restar el numero de caracteres que hayamos avanzado en la comprobacion antes de volver al bucle buscador, por ello debemos primero resetear
    li $s4, 0
    move $s6, $s1
    addi $s6, $s6 -1
    j encontrada_restador
    
encontrada_restador:
    beq $s4, $s6, encontrada_salir
    addi $s3, -1
    addi $s4, $s4, 1
    j encontrada_restador
    
encontrada_salir:
    la $a0, asterisco
    li $v0, 4
    syscall
    j bucle_buscador_primer_caracter
    
fallida:
    #debemos restar el numero de caracteres que hayamos avanzado en la comprobacion antes de volver al bucle buscador, por ello debemos primero resetear
    li $t4, 0
    move $s6, $s4
    addi $s6, $s6 -1
    move $a0, $s5
    li $v0, 11
    syscall
    j fallida_restador
fallida_restador:
    beq $t4, $s6, fallida_salir
    addi $s3, -1
    addi $t4, $t4, 1
    j fallida_restador
    
fallida_salir:
    addi $t4, 0
    j bucle_buscador_primer_caracter
    
se_acabo:
    li $v0, 10
    syscall
    
    
   
    
    
    
    
    
    
    
    
