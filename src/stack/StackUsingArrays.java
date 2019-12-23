package stack;

public class StackUsingArrays {
	protected int[] data;
	protected int top;
	protected int size;
	
	public static final int DEFAULT_SIZE = 5;
	public StackUsingArrays() {
		this(DEFAULT_SIZE);
	}
	
	public StackUsingArrays(int size) {
		data = new int[size];
		top = -1;
		this.size = 0;
	}
	
	public int top() {
		return this.data[top];
	}
	
	public boolean isEmpty() {
		return this.size==0;
	}
	
	public boolean isFull() {
		return this.size == this.data.length;
	}
	
	public void push(int item) throws Exception{
		if(this.isFull()) {
			throw new Exception("Stack is Full");
		}
		this.top++;
		this.data[this.top] = item;
		this.size++;
	}
	
	public int pop() throws Exception{
		if(this.isEmpty())
			throw new Exception("Stack is Empty");
		int rv = this.data[this.top];
		this.top--;
		this.size--;
		return rv;
	}
	
	public void disp() {
		if(this.size == 0)
			System.out.print("END");
		int tCopy = this.top;
		while(tCopy>=0) {
			System.out.print(this.data[tCopy] + "  ");
			tCopy--;
		}
	}
}
