#Realizar un programa que pida dos números enteros, los sume y muestre el resultado. El diseño del programa ha de ser tal que funcione de acuerdo con los mensajes que se muestran en el recuadro. Tanto los datos de entrada como el resultado de la suma ha de almacenarse en memoria. Para la suma use la instrucción de suma "add $rd, $rs, $rt”

.data
    DATOA: .asciiz "Introduce el valor A: "
    DATOB: .asciiz "Introduce el valor B: "
    RESULTADO: .asciiz "El resultado de la suma es: "
    buffer_valor1: .space 10
    buffer_valor2: .space 10
.text
main:
    # para hacer este ejercicio, debemos comprobar si los valores introducidos
    # son numeros, para ello, pediremos que el usuario importe una string
    # y compararemos ese string para ver si es un caracter ascii de tipo numero
    
    la $t0, DATOA
    li $s0, 48 # variable recorredora ascii
    li $s4, 58 # limite de bucle
    li $s5, 10 # multiplicador x 10
    li $s1, 0  # sumando 1
    li $s2, 0  # sumando 2 
    # pedimos primer valor
    move $a0, $t0
    li $v0, 4
    syscall
    li $v0, 8
    la $a0, buffer_valor1
    li $a1, 10
    syscall
    jal primer_valor_check
    # pedimos segundo valor
    li $a0, '\n'
    li $v0, 11
    syscall
    la $a0, DATOB
    li $v0, 4
    syscall
    li $v0, 8
    la $a0, buffer_valor2
    li $a1, 10
    syscall
    jal segundo_valor_check
    # sumamos ambos valores
    add $t1, $s1, $s2
    # lo enseñamos en pantalla
    li $a0, '\n'
    li $v0, 11
    syscall
    la $a0, RESULTADO
    li $v0, 4
    syscall
    move $a0, $t1
    li $v0, 1
    syscall
    # cerramos programa
    li $v0, 10
    syscall
    
    
primer_valor_check:
    lbu $s3, 0($a0)
    beq $s3, '\n', se_acabo_la_busqueda_1
    beq $s0, $s4, no_es_numero_1
    beq $s3, $s0, numero_encontrado_1
    addi $s0, $s0, 1
    j primer_valor_check
    
numero_encontrado_1:
    addi $s3, $s3, -48
    mul $s1, $s1, $s5
    add $s1, $s1, $s3
    li $s0, 48
    addi $a0, $a0, 1
    j primer_valor_check
    
se_acabo_la_busqueda_1:
    li $s0, 48
    jr $ra
    
no_es_numero_1:
    j main
    
segundo_valor_check:
    lbu $s3, 0($a0)
    beq $s3, '\n', se_acabo_la_busqueda_2
    beq $s0, $s4, no_es_numero_2
    beq $s3, $s0, numero_encontrado_2
    addi $s0, $s0, 1
    j segundo_valor_check
    
numero_encontrado_2:
    addi $s3, $s3, -48
    mul $s2, $s2, $s5
    add $s2, $s2, $s3
    li $s0, 48
    addi $a0, $a0, 1
    j segundo_valor_check
    
se_acabo_la_busqueda_2:
    li $s0, 48
    jr $ra
    
no_es_numero_2:
    j main
    
    

    
    
    
    
