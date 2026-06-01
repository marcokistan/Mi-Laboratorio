.data
    mi_array: .word 1, 2, 3, 4
.text
main:
    la $s0, mi_array
    jal recursividad
    li $v0, 10
    syscall
recursividad:
    # pre check
    lw $t3, 0($s0)
    lw $t4, 8($s0)
    beq $t3, $t4, fin_recusivo
    addi $sp, $sp, -4
    sw $ra, 0($sp)
    lw $t0, 0($s0)
    move $a0 , $t0
    li $v0, 1
    syscall
    addi $s0, $s0, 4
    jal recursividad
    lw $ra, 0($sp)
    addi $sp, $sp, 4 
    jr $ra
fin_recusivo:
    jr $ra
    
    
