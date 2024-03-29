public class Calculator{
	Item[] expr;
	int ip;
	Stack stack;

	public Calculator (Item[] expr) {
		this.expr = expr;
		this.ip = 0; //instruction pointer
		this.stack = new Stack();
	}

	public int run(){
		while(ip < expr.length)
			step();
		return stack.pop();
	}

	public void step(){
		Item nxt = expr[ip++];
		switch (nxt.getType()){
			case ADD: {
				int y = stack.pop();
				int x = stack.pop();
				stack.push (x + y);
				break;
			}
			case SUB: {
				int y = stack.pop();
				int x = stack.pop();
				stack.push ( x - y);
				break;
			}
			case MUL: {
				int y = stack.pop();
				int x = stack.pop();
				stack.push( x * y);
				break;
			}
			case DIV: {
				int y = stack.pop();
				int x = stack.pop();
				stack.push( x / y);
				break;
			}
			case VALUE: {
				stack.push(nxt.getValue());
				break;
			}
			case PNUMBER: {
				int x = stack.pop() * 2;
				if(x >= 10)
					x = x - 9;
				stack.push(x);
				break;
			}
			case MODULO10: {
				stack.push(stack.pop() % 10);
				break;
			}
		}
	}
}