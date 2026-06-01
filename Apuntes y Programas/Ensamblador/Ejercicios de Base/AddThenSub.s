.data
    mensaje: .asciiz"La suma de los dos valores es "
    nuevalinea: .asciiz"\n"
    mensaje2: .asciiz"La resta del resultado de la suma por el inmediato 30 es "
.text
main:
    # la suma va a ser de 20 + 30
    li $t0, 20
    li $t1, 30
    add $s0, $t1, $t0
    li $v0, 4
    la $a0, mensaje
    syscall
    # segunda parte
    move $a0, $s0
    li $v0, 1
    syscall
    # nueva linea
    la $a0, nuevalinea
    li $v0, 4
    syscall
    # efectuamos la resta
    addi $s1, $s0, -30 # no hay subi
    la $a0, mensaje2
    li $v0, 4
    syscall
    # imprimimos el numero
    move $a0, $s1
    li $v0, 1
    syscall
    # 4. Salir del programa

    li $v0, 10 # Código para finalizar ejecución

    syscall
