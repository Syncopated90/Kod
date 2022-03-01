  # labwork.S
  # Written 2015-2017 by F Lundevall
  # Skeleton file for IS1200/IS1500 lab 1.
  # The macros PUSH and POP are in the public domain.
  # Please add your own code at the end of the file.

  #
  # Please keep the two macros PUSH and POP unchanged
  #
.macro	PUSH reg
	addi	$sp,$sp,-4
	sw	\reg,0($sp)
.endm

.macro	POP reg
	lw	\reg,0($sp)
	addi	$sp,$sp,4
.endm
  #
  # Please add your own code below this line
  #
  # timetemplate.asm
  # Written 2015 by F Lundevall
  # Copyright abandonded - this file is in the public domain.
  # timetemplate.asm
  # Written 2015 by F Lundevall
  # Copyright abandonded - this file is in the public domain.
        .global delay
        .global time2string        

        .data
        .align 2
mytime:	.word 0x5950
timstr:	.ascii "text more text lots of text\0"
	.text
main:
	# print timstr
	la	$a0,timstr
	li	$v0,4
	syscall
	nop
	# wait a little
	li	$a0,1000
	jal	delay
	nop
	# call tick
	la	$a0,mytime
	jal	tick
	nop
	# call your function time2string
	la	$a0,timstr
	la	$t0,mytime
	lw	$a1,0($t0)
	jal	time2string
	nop
	# print a newline
	li	$a0,10
	li	$v0,11
	syscall
	nop
	# go back and do it all again
	j	main
	nop
# tick: update time pointed to by $a0
tick:	lw	$t0,0($a0)	# get time
	addiu	$t0,$t0,1	# increase
	andi	$t1,$t0,0xf	# check lowest digit
	sltiu	$t2,$t1,0xa	# if digit < a, okay
	bnez	$t2,tiend
	nop
	addiu	$t0,$t0,0x6	# adjust lowest digit
	andi	$t1,$t0,0xf0	# check next digit
	sltiu	$t2,$t1,0x60	# if digit < 6, okay
	bnez	$t2,tiend
	nop
	addiu	$t0,$t0,0xa0	# adjust digit
	andi	$t1,$t0,0xf00	# check minute digit
	sltiu	$t2,$t1,0xa00	# if digit < a, okay
	bnez	$t2,tiend
	nop
	addiu	$t0,$t0,0x600	# adjust digit
	andi	$t1,$t0,0xf000	# check last digit
	sltiu	$t2,$t1,0x6000	# if digit < 6, okay
	bnez	$t2,tiend
	nop
	addiu	$t0,$t0,0xa000	# adjust last digit
tiend:	sw	$t0,0($a0)	# save updated result
	jr	$ra		# return
	nop

time2string:
	PUSH $s0
	PUSH $s1
	PUSH $s2
	PUSH $s3
	PUSH $s4
	PUSH $s5
	PUSH $s6
	PUSH $s7
	PUSH $gp
	PUSH $sp
	PUSH $fp
	PUSH $ra
	
	andi $t0, $a1, 0xf000#f?rsta minutsiffran
	srl $t0, $t0, 12
	add $a2, $t0, $0
	jal hexasc	
	nop
	sb $v0, 0($a0)	
	andi $t1, $a1, 0xf00#andra minutsiffran
	srl $t1, $t1, 8
	add $a2, $t1, $0	
	jal hexasc
	nop
	sb $v0, 1($a0)	
	addi $t2, $0, 0x3a#kolon
	sb $t2, 2($a0)
	andi $t3, $a1, 0xf0#f?rsta sekundsiffran
	srl $t3, $t3, 4
	add $a2, $t3, $0	
	jal hexasc
	nop
	sb $v0, 3($a0)
	andi $t4, $a1, 0xf#andra sekundsiffran
	add $a2, $t4, $0	
	jal hexasc
	nop
	sb $v0, 4($a0)
	addi $t5, $0, 0 #null
	sb $t5, 5($a0)
	
	POP $ra
	POP $fp
	POP $sp
	POP $gp
	POP $s7
	POP $s6
	POP $s5
	POP $s4
	POP $s3
	POP $s2
	POP $s1
	POP $s0
	jr $ra
	nop
	
hexasc:
	andi $t0, $a2, 0xf
	addi $t1, $0, 9
	ble $t0, $t1, numbers
	nop
letters:
	add $v0, $t0, 0x37
	jr $ra
	nop
numbers:
	add $v0, $t0, 0x30
	jr $ra
	nop

delay:
	PUSH $s0
	PUSH $s1
	PUSH $s2
	PUSH $s3
	PUSH $s4
	PUSH $s5
	PUSH $s6
	PUSH $s7
	PUSH $gp
	PUSH $sp
	PUSH $fp
	PUSH $ra
	
	
delay_loop:
	ble $a0, $0, exit_loop
	nop
	addi $a0, $a0, -1
	addi $t0, $0, 0 #motsvarar i, nollställer registret
	addi $t1, $0, 13500 #motsvarar is maxvärde
inner_loop:
	beq $t0, $t1, delay_loop
	nop
	addi $t0, $t0, 1
	j inner_loop
	nop
	
	
exit_loop:
	POP $ra
	POP $fp
	POP $sp
	POP $gp
	POP $s7
	POP $s6
	POP $s5
	POP $s4
	POP $s3
	POP $s2
	POP $s1
	POP $s0
	jr $ra
	nop
