.data
    mensaje: .asciiz"Escribe un numero, vamos a comprobar si lo es: "
    nuevalinea: .asciiz"\n"
    buffer: .space 20
    errordetext: .asciiz"vaya... parece que no es un numero, vuelve a intentarlo..."
    yey: .asciiz"enhorabuena! este valor si es un numero: "
.text
main:
    li $v0, 4
    la $a0, mensaje
    syscall
    li $v0, 8
    la $a0, buffer
    li $a1, 20
    syscall
    # vamos a comprobar si es un numero
    li $s0, 0
    li $t2, 10
    la $s2, nuevalinea
    move $t0, $a0
loop_validacion:
    lbu $t1, ($t0)
    beq $t1, $t2, fin
    slti $t5, $t1, 48
    bne $t5, $zero, error
    slti $t5, $t1, 58
    beq $zero, $t5, error
    # hacemos conversion
    addi $t1, $t1, -48
    mul $s0, $s0, $t2
    add $s0, $s0, $t1
    addi $t0, $t0, 1
    j loop_validacion
error:
    li $v0, 4
    la $a0, nuevalinea
    syscall
    li $v0, 4
    la $a0, errordetext
    syscall
    li $v0, 4
    la $a0, nuevalinea
    syscall
    j main
fin:
    li $v0, 4
    la $a0, nuevalinea
    syscall
    li $v0, 4
    la $a0, yey
    syscall
    li $v0, 1
    move $a0, $s0
    syscall
    li $v0, 10
    syscall
    
    
