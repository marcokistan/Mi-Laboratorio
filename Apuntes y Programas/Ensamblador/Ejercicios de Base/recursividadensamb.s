.data
    mensajeinput: .asciiz"Introduce un numero, lo vamos a sumar desde dicho hasta 0: "
    nuevalinea: .asciiz"\n"
    resultadofinal: .asciiz"el resultado final es: "
.text
main:
    #primero vamos a necesitar preguntar al usuario
    li $v0, 4
    la $a0, mensajeinput
    syscall
    li $v0, 5
    syscall
    move $s1, $v0 # en $s1 guardaremos el input temporalmente, hay que guardarlo en un s, por que vamos a invocar una función.
    # ahora vamos a llamar a la recursividad
    jal recursividad
    # vamos a preparar el codigo para cuando vuelva
    li $v0, 4
    la $a0, resultadofinal
    syscall
    # he decidido que el resultado final se guardará en $s0
    li $v0, 1
    move $a0, $s0
    syscall
    # salimos del programa
    li $v0, 10
    syscall
    
    
recursividad:
    addi $sp, $sp, -8 # cada registro son 4 bytes (32 bits), queremos guardar dos registros, asi que 8 bytes.
    sw $ra, 0($sp) # por alguna rara razon la sintaxis es al reves en sw 
    sw $s1, 4($sp)
    # comprobacion
    beq $zero, $s1, ceroalcanzao
    # resta
    addi $s1, $s1, -1
    jal recursividad
    addi $sp, $sp, 8
    # suma
    lw $s1, 4($sp)
    add $s0, $s0, $s1
    # regresamos
    lw $ra, 0($sp)
    jr $ra
    
ceroalcanzao:
    jr $ra
    
    
    

