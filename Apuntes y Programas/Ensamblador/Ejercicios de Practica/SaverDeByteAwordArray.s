.data
    datosb: .byte 1, 2, 6
    .align 2 #2^n, n -> propio numero
    datosw: .space 12
.text
    main:
    # guardamos datos b en $s0 y datos w en $s1
    la $s0, datosb
    la $s1, datosw
    li $s2, 0 #variable contadora
    li $s3, 0 #variable contadora 2
    j bucle
    bucle:
        li $t1, 3
        beq $s2, $t1, final_bucle
        addi $s2, $s2, 1
        lbu $t0, 0($s0)
        sw $t0, 0($s1)
        addi $s0, $s0, 1
        addi $s1, $s1, 4
        j bucle
    final_bucle:
        la $s1, datosw
        j nuevo_bucle
    nuevo_bucle:
        li $t1, 3
        beq $s3, $t1, clausurar
        addi $s3, $s3, 1
        lw $a0, 0($s1)
        li $v0, 1
        syscall
        addi $s1, $s1, 4
        j nuevo_bucle
    clausurar:
        li $v0, 10
        syscall
        
        
        
     
        

        
    
    
  
    
    
