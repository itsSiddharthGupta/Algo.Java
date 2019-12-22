package linkedlist;

import jdk.jfr.Description;

public class DoublyLinkedList<T> {
	class Node{
		T data;
		Node next;
		Node prev;
		Node(T data){
			this.data = data;
			this.next = null;
			this.prev = null;
		}
		@Override
		public String toString() {
			return this.data+"";
		}
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	DoublyLinkedList(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public void addFirst(T data) {
		Node node = new Node(data);
		node.prev = null;
		if(this.size == 0) {
			this.head = node;
			node.next = null;
			this.tail = node;
			this.size++;
		}else {
			node.next = this.head;
			this.head.prev = node;
			this.head = node;
			this.size++;
		}
	}
	
	public void addLast(T data) {
		Node node = new Node(data);
		node.next = null;
		if(this.size == 0) {
			this.head = node;
			node.prev = null;
			this.tail = node;
			this.size++;
		}else {
			node.prev = this.tail;
			this.tail.next = node;
			this.tail = node;
			this.size++;
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public T get(int pos) {
		int index = pos-1;
		Node ans = null;
		if(index>=0 && index < size) {
			Node tmp = this.head;
			while(index>0) {
				tmp = tmp.next;
				index--;
			}
			ans = tmp;
		}else {
			throw new ArrayIndexOutOfBoundsException();
		}
		return ans.data;
	}

	public T removeFirst() throws java.lang.Exception {
		T ans = null;
		if(this.size>0) {
			Node tmp = this.head;
			ans = tmp.data;
			this.head = tmp.next;
			tmp.next.prev = null;
			tmp.next = null;
			this.size--;
		}else {
			throw new Exception("List is Empty");
		}
		return ans;
	}
	
	public T removeLast() throws java.lang.Exception {
		T ans = null;
		if(this.size>0) {
			Node tmp = this.tail;
			ans = tmp.data;
			this.tail = tmp.prev;
			tmp.prev.next = null;
			tmp.prev = null;
			this.size--;
		}else {
			throw new Exception("List is Empty");
		}
		return ans;
	}

	@Description("Returns the index of first occurence of the element to find")
	public int indexOf(T key) {
		int ans = -1;
		Node tmp = this.head;
		int index = 0;
		while(tmp!=null) {
			if(tmp.data == key) {
				ans = index;
				break;
			}
			tmp=tmp.next;
			index++;
		}
		return ans;
	}
	
	public void display() {
		Node tmp = this.head;
		System.out.print("{");
		while(tmp!=null) {
			System.out.print(tmp + ", ");
			tmp = tmp.next;
		}
		System.out.print("}" + "\n");
	}
}
