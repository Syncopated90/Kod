public class Stack{
	private int[] array;
	private int sp;

	public Stack(){
		this.array = new int[4];
		this.sp = 0;
	}

	/*public void push(int value){//array size increases with 20
		if(this.sp == this.array.length){
			int[] newArray = new int[this.array.length + 20];
			for( int i = 0; i < this.array.length; i++)
				newArray[i] = this.array[i];
			this.array = newArray;
		}
		array[this.sp] = value;
		this.sp++;
	}
	public int pop(){//array size decreases with 20
			if(sp < this.array.length - 40){
				int[] newArray = new int[this.array.length - 20];
				for( int i = 0; i < this.array.length - 40; i++)
					newArray[i] = this.array[i];
				this.array = newArray;
			}
			if(sp > 0){
				this.sp--;
				return array[this.sp];
			}
			else
				System.out.println("Stack is empty");
				return 0;
	}*/
	public int pop(){//array size is halved
		if(sp < this.array.length / 4){
			int[] newArray = new int[this.array.length / 2];
			for( int i = 0; i < this.array.length / 4; i++)
				newArray[i] = this.array[i];
			this.array = newArray;
		}
		if(sp > 0){
			this.sp--;
			return array[this.sp];
		}
		else
			System.out.println("Stack is empty");
			return 0;
	}
	//array size is doubled
	public void push(int value){
		if(this.sp == this.array.length){
			int[] newArray = new int[this.array.length * 2];
			for( int i = 0; i < this.array.length; i++)
				newArray[i] = this.array[i];
			this.array = newArray;
		}
		array[this.sp] = value;
		this.sp++;
	}
	/*public void push(int value){ //Static stack
			array[this.sp] = value;
			this.sp++;
	}
	public int pop(){
			if(sp > 0){
				this.sp--;
				return array[this.sp];
			}
			else
				System.out.println("Stack is empty");
				return 0;
	}*/
}