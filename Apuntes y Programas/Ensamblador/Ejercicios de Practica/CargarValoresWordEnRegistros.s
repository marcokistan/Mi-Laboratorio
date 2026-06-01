# Realizar un programa con instrucciones nativas del procesador MIPS para cargar en el registro $v0 la primera palabra (word) de las dos definidas en el segmento de datos a partir de la dirección "wd".Al programa anterior, añadir una sola instrucción nativa para que el programa resultante también cargue en el registro $v1 la palabra en la dirección "wd + 4"

.data
    wd: .word 192, 0x66558433 #aqui establecemos las dos palabras. Esto es un array.
    
.text
main:
    la $s0, wd
    lw $v0, 0($s0)
    lw $v1, 4($s0)
    # comprobacion
    move $a0, $v0
    li $v0, 1
    syscall
    li $a0, '\n'
    li $v0, 11
    syscall
    move $a0, $v1
    li $v0, 1
    syscall
    li $v0, 10
    syscall
    


