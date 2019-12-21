package hashtable;

import java.util.LinkedList;

public class GenericHashMap<T, V> {
	class Pair{
		T key;
		V value;
		Pair(T key, V value){
			this.key = key;
			this.value = value;
		}
		@Override
		public boolean equals(Object obj) {
			Pair other = (Pair)obj;
			return this.key.equals(other.key);
		}
		@Override
		public String toString() {
			return "[" + this.key + " : " + this.value + "]";
		}
	}
	private LinkedList<Pair>[] arr;
	private static final int DEFAULT_SIZE = 5;
	private int size;
	GenericHashMap(){
		this.arr = new LinkedList[DEFAULT_SIZE];
		this.size = 0;
	}
	
	public void put(T key, V value) {
		Pair p = new Pair(key, value);
		int index = Math.abs(key.hashCode())%arr.length;
		LinkedList<Pair> l = arr[index];
		if(l==null) {
			l = new LinkedList<>();
			l.addLast(p);
			this.arr[index] = l;
			this.size++;
		}else {
			int findIndex = l.indexOf(p);
			if(findIndex==-1) {
				l.addLast(p);
				this.size++;
			}else {
				Pair op = l.get(findIndex);
				op.value = value;
			}
		}
		double loadFactor = (this.size/this.arr.length);
		if(loadFactor > 0.75) {
			rehash();
		}
	}

	public V get(T key) {
		V val = null;
		Pair p = new Pair(key, null);
		int index = Math.abs(key.hashCode())%arr.length;
		LinkedList<Pair> l = this.arr[index];
		if(l==null) {
			System.out.println("Not Present.");
		}else {
			int findIndex = l.indexOf(p);
			if(findIndex==-1)
				System.out.println("Not Present.");
			else {
				val = l.get(findIndex).value;
			}
		}
		return val;
	}
	
	public void remove(T key) {
		Pair p = new Pair(key, null);
		int index = Math.abs(key.hashCode())%arr.length;
		LinkedList<Pair> l = this.arr[index];
		if(l==null) {
			System.out.println("Not Present.");
		}else {
			int findIndex = l.indexOf(p);
			if(findIndex==-1)
				System.out.println("Not Present.");
			else {
				l.remove(findIndex);
				this.size--;
			}
		}
	}

	@Override
	public String toString() {
		String toString = "";
		for(LinkedList<Pair> l : this.arr) {
			if(l!=null) {
				for(int i = 0;i<l.size();i++) {
					Pair p = l.get(i);
					toString += p.toString() + "\n";
				}
			}
		}
		return toString;
	}
	
	private void rehash() {
		LinkedList<Pair>[] old = this.arr;
		this.arr = new LinkedList[old.length*2];
		this.size = 0;
		for(LinkedList<Pair> l : old) {
			while(l!=null && l.size()!=0) {
				Pair p = l.removeFirst();
				this.put(p.key, p.value);
			}
		}
	}
}
