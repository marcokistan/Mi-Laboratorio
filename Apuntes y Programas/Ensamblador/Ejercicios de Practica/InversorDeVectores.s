.data
    # 1. Definición del vector y su tamaño
    vector: .word 5, 12, -3, 8, 14, 99, 1  # Vector de prueba (7 elementos)
    tamano: .word 7                       # Número de elementos
.text
main:
    # cargamos el tamño en registro $s0
    la $s0, tamano
    lw $s0, 0($s0)
    # cargamos array en registro $s1
    la $s1, vector
    # inicializamos una variable contadora en $s2
    li $s2, 0
    # imprimimos el vector tal cual lo recibimos
    jal impresor_1
    # guardamos cada valor del vector con un bucle en memoria
    jal guardador_de_elementos
    # sobre-escribimos el vector
    jal sobre_escribidor_de_elementos
    # imprimimos caracter de nueva linea
    li $a0, 10
    li $v0, 11
    syscall
    # llamamos al segundo impresor
    jal impresor_2
    # cerramos programa
    li $v0, 10
    syscall


impresor_1:
    beq $s2, $s0, fin_de_impresor
    addi $s2, $s2, 1
    lw $t0, 0($s1)
    move $a0, $t0
    li $v0, 1
    syscall
    li $a0 , ','
    li $v0, 11
    syscall
    addi $s1, $s1, 4
    j impresor_1
    
fin_de_impresor:
    # reinciamos contador
    li $s2, 0
    # reinciamos el puntero del vector
    la $s1, vector
    #volvemos a main
    jr $ra
    
impresor_2:
    beq $s2, $s0, fin_de_impresor2
    addi $s2, $s2, 1
    lw $t0, 0($s1)
    move $a0, $t0
    li $v0, 1
    syscall
    li $a0 , ','
    li $v0, 11
    syscall
    addi $s1, $s1, 4
    j impresor_2
    
fin_de_impresor2:
    # reinciamos contador
    li $s2, 0
    # reinciamos el puntero del vector
    la $s1, vector
    #volvemos a main
    jr $ra
    

guardador_de_elementos:
    beq $s2, $s0, fin_de_bucle
    addi $s2, $s2, 1
    lw $t0, 0($s1)
    addi $sp, $sp, -4
    sw $t0, 0($sp) #empezamos en 96
    addi $s1, $s1, 4
    j guardador_de_elementos
    
    
fin_de_bucle:
    # reinciamos contador
    li $s2, 0
    # reinciamos el puntero del vector
    la $s1, vector
    #volvemos a main
    jr $ra
    
sobre_escribidor_de_elementos:
    beq $s2, $s0, fin_de_bucle_2
    addi $s2, $s2, 1
    lw $t1, 0($sp)
    addi $sp, $sp, 4
    sw $t1, 0($s1)
    addi $s1, $s1, 4
    j sobre_escribidor_de_elementos
    
fin_de_bucle_2:
    # restauramos memoria a su default, alineandola bien.
    addi $sp, $sp, -4
    # reinciamos contador
    li $s2, 0
    # reinciamos el puntero del vector
    la $s1, vector
    #volvemos a main
    jr $ra
    
