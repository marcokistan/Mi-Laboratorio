.data
    mensaje: .asciiz"Vamos a simular una lista, escribe el num maximo de la lista y se rellenara del 0 a ese numero: "
    nuevalinea: .asciiz"\n"
    resultado: .asciiz"La lista consecuente es: "
.text
main:
    #primero pedimos input
    li $v0, 4
    la $a0, mensaje
    syscall
    li $v0, 5
    syscall
    # movemos input a $s1
    move $s1, $v0
    # preparamos el salto recursivo
    jal recursividad
    # preparamos la salida al volver
    li $v0, 10
    syscall
recursividad:
    # necesito 8 bytes en Stack, 4 para ra, 4 para s1
    addi $sp, $sp, -8
    sw $ra, 0($sp)
    sw $s1, 4($sp)
    # caso base n == 0
    beq $s1, $zero, finalrecursion
    # no caso base
    addi $s1, $s1, -1
    jal recursividad
    # vuelta del caso base
    addi $sp, $sp, 8
    lw $s1, 4($sp)
    lw $ra, 0($sp)
    li $v0, 1
    move $a0, $s1
    syscall
    li $v0, 4
    la $a0, nuevalinea
    syscall
    jr $ra
finalrecursion:
    li $v0, 4
    la $a0, resultado
    syscall
    li $v0, 4
    la $a0, nuevalinea
    syscall
    li $v0, 1
    move $a0, $s1
    syscall
    li $v0, 4
    la $a0, nuevalinea
    syscall
    jr $ra
    
    
