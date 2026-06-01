.data
    mensaje: .asciiz"Introduce un numero, vamos a comprobar si es mayor a 10 "
    nuevalinea: .asciiz"\n"
    mensaje2: .asciiz"El numero no parece ser mayor a 10"
    mensaje3_1: .asciiz"El numero: "
    mensaje3_2: .asciiz" parece que si es mayor que 10"
.text
main:
    #printeamos mensaje
    la $a0, mensaje
    li $v0, 4
    syscall
    # esperamos input
    li $v0, 5
    syscall
    move $s0, $v0
    # aplicamos condicionalidad
    li $t0, 11
    slt $t1, $s0, $t0
    beq $zero, $t1, mayora10
    # aqui va el else, por que ensamblador sigue hacia abajo, ya que no salta
    # nos conviene incluir un jump al final para que no ejecute mayora10 sin querer.
    la $a0, nuevalinea
    li $v0, 4
    syscall
    la $a0, mensaje2
    li $v0, 4
    syscall
    j finapp
    

mayora10: 
    la $a0, mensaje3_1
    li $v0, 4
    syscall
    move $a0, $s0
    li $v0, 1
    syscall
    la $a0, mensaje3_2
    li $v0, 4
    syscall

finapp:
    li $v0, 10
    syscall

