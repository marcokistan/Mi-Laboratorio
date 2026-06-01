.data
    mensaje: .asciiz"Introduce un número, se le sumara 10: "
    nuevalinea: .asciiz"\n"
.text
main:
    # imprimimos mensaje
    la $a0, mensaje
    li $v0, 4
    syscall
    # pedimos input
    li $v0, 5
    syscall
    move $a0, $v0
    # efectuamos la suma
    addi $s0, $a0, 10
    # imprimimos una nueva linea
    la $a0, nuevalinea
    li $v0, 4
    syscall
    # imprimimos el int
    move $a0, $s0
    li $v0, 1
    syscall
    # cerramos el programa
    li $v0, 10
    syscall
    
