package queue;

public class Queue {
	//Creating a class queue using an array;
	protected int[] dataQueue;
	protected int front;
	protected int size;
	protected static final int DEFAULT_SIZE = 5;
	
	public Queue() {
		this(DEFAULT_SIZE);
	}
	
	public Queue(int size) {
		this.dataQueue = new int[size];
		this.front = 0;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public boolean isFull() {
		return size==this.dataQueue.length;
	}
	
	public void enQueue(int data) throws Exception {
		if(this.isFull()) {
			throw new Exception("Queue is Full");
		}
		int availableIndex = (this.size + this.front)%this.dataQueue.length;
		this.dataQueue[availableIndex] = data;
		this.size++;
	}
	
	public int deQueue() throws Exception{
		if(this.isEmpty()) {
			throw new Exception("Queue is Empty");
		}
		int rv = this.dataQueue[this.front];
		this.front = (this.front + 1)%this.dataQueue.length;
		this.size--;
		return rv;
	}
	
	public void displayQueue() throws Exception{
		if(this.isEmpty()) {
			throw new Exception("Queue is Empty");
		}
		int frontCopy = this.front;
		for(int i = size;i>0;i--) {
			System.out.print(this.dataQueue[frontCopy] + " <= ");
			frontCopy = (frontCopy+1)%this.dataQueue.length;
		}
	}
	
	public int returnFrontData() {
		return this.dataQueue[this.front];
	}
	
	public int returnFrontIndex() {
		return this.front;
	}
}
