public class Stack{
	//static stack
	private int[] array;
	private int sp;

	public Stack(){
		this.array = new int[4];
		this.sp = 0;
	}
	public void push(int value){
		if(sp < 4){ // change four to array.length for longer stacks
			array[this.sp] = value;
			this.sp++;
		}
		else
			System.out.println("Stack overflow error");
	}
	public int pop(){
		if(sp > 0){
			this.sp--;
			return array[this.sp];
		}
		else
			System.out.println("Stack is empty");
			return 0;
	}

}