# Dado el siguiente segmento de datos donde se definen un conjunto de datossin signo de tipo byte a partir de la dirección "datosb", realizar un programa que los lea uno a uno y los almacene a continuación, a partir de la dirección "datosw", pero de tipo word (4 bytes por dato):

# la primera direccion en ensamblador es 0x1000. y va sumando + 1.

.data
    datosb: .byte 0x10, 0x80, 0x75 #array de bytes, cada byte en 0x1000, 0x1001, 0x1002.
    .align 2 # store word requiere que la memoria este alineada en un multiplo de 4. .align funciona tal que 2^n, por eso ponemos 2. 2^2 = 4.
    # datos w, empezaria en 0x1003, 3 no es multiplo de 4, por lo que tenemos que alinear la memoria.
    datosw: .space 20
.text
main:
    la $s0, datosb
    la $s1, datosw
    lbu $s2, 2($s0)
    jal bucle_anadidor
    li $v0, 10
    syscall
bucle_anadidor:
    lbu $t0, 0($s0)
    sw $t0, 0($s1)
    addi $s1, $s1, 4
    addi $s0, $s0, 1
    move $a0, $t0
    li $v0, 1
    syscall
    beq $t0, $s2, final
    j bucle_anadidor
    
final:
    jr $ra
    
