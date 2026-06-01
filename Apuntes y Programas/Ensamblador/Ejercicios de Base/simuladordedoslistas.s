.data
    mensaje: .asciiz"Escribe 6 numeros, los vamos a guardar en una lista"
    nuevalinea: .asciiz"\n"
    mensaje2: .asciiz"Escribe 6 numeros, los vamos a guardar en OTRA lista"
    lista1: .asciiz"Resultado de la lista 1: "
    lista2: .asciiz"Resultado de la lista 2: "
.text
main:
    #declaramos unas constantes, queremos 6 numeros por lista asi que vamos a declarar que $s1 sea 7
    li $s1 , 7
    li $s2, 0
    li $v0, 4
    la $a0, mensaje
    syscall
    li $v0, 4
    la $a0, nuevalinea
    syscall
    jal primeralista
    addi $sp, $sp, -52
    li $v0, 4
    la $a0, mensaje2
    syscall
    li $v0, 4
    la $a0, nuevalinea
    syscall
    li $s2, 0
    jal segundalista
    # empezamos a obtener los valores, primero reseteamos el stack pointer
    addi $sp, $sp, 52
    li $v0, 4
    la $a0, nuevalinea
    syscall
    li $v0, 4
    la $a0, lista1
    syscall
    addi $sp, $sp, -8
    lw $a0 , 4($sp)
    li $v0, 1
    syscall
    addi $sp, $sp, -8
    lw $a0 , 4($sp)
    li $v0, 1
    syscall
    addi $sp, $sp, -8
    lw $a0 , 4($sp)
    li $v0, 1
    syscall
    addi $sp, $sp, -8
    lw $a0 , 4($sp)
    li $v0, 1
    syscall
    addi $sp, $sp, -8
    lw $a0 , 4($sp)
    li $v0, 1
    syscall
    addi $sp, $sp, -8
    lw $a0 , 4($sp)
    li $v0, 1
    syscall
    # ahora los de la segunda lista
    addi $sp, $sp, 48
    addi $sp, $sp, -52
    li $v0, 4
    la $a0, nuevalinea
    syscall
    li $v0, 4
    la $a0, lista2
    syscall
    addi $sp, $sp, -8
    lw $a0 , 4($sp)
    li $v0, 1
    syscall
    addi $sp, $sp, -8
    lw $a0 , 4($sp)
    li $v0, 1
    syscall
    addi $sp, $sp, -8
    lw $a0 , 4($sp)
    li $v0, 1
    syscall
    addi $sp, $sp, -8
    lw $a0 , 4($sp)
    li $v0, 1
    syscall
    addi $sp, $sp, -8
    lw $a0 , 4($sp)
    li $v0, 1
    syscall
    addi $sp, $sp, -8
    lw $a0 , 4($sp)
    li $v0, 1
    syscall
    li $v0, 10
    syscall
    
    
    
primeralista:
    # necesitamos 8 bytes
    addi $s2, $s2, 1
    beq $s1, $s2, primeralistaterminada
    #else
    addi $sp, $sp, -8
    sw $ra, 0($sp)
    li $v0, 5
    syscall
    sw $v0, 4($sp)
    jal primeralista
    lw $ra, 0($sp)
    addi $sp, $sp, 8
    jr $ra
    
primeralistaterminada:
    jr $ra
    
segundalista:
    # necesitamos 8 bytes
    addi $s2, $s2, 1
    beq $s1, $s2, segundalistaterminada
    #else
    addi $sp, $sp, -8
    sw $ra, 0($sp)
    li $v0, 5
    syscall
    sw $v0, 4($sp)
    jal segundalista
    lw $ra, 0($sp)
    addi $sp, $sp, 8
    jr $ra
    
segundalistaterminada:
    jr $ra
    
