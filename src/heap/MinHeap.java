package heap;

import java.util.ArrayList;

public class MinHeap{
	private ArrayList<Integer> data = new ArrayList<>();
	public void add(int item) {
		data.add(item);
		upheapify(this.data.size() - 1);
	}
	private void upheapify(int ci) {
		int pi = (ci-1)/2;
		if(data.get(ci) < data.get(pi)) {
			swap(ci, pi);
			upheapify(pi);
		}
	}
	private void swap(int i, int j) {
		int ith = this.data.get(i);
		int jth = this.data.get(j);
		this.data.set(i, jth);
		this.data.set(j, ith);
	}
	public void display() {
		System.out.println(this.data);
	}
	public int size() {
		return this.data.size();
	}
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	public int remove() {
		this.swap(0,this.data.size()-1);
		int rv = this.data.remove(this.data.size() - 1);
		downHeapify(0);
		return rv;
	}
	private void downHeapify(int pi) {
		int lci = 2*pi + 1;
		int rci = 2*pi + 2;
		int mini = pi;
		if(lci < this.data.size() && this.data.get(lci) < this.data.get(mini))
			mini = lci;
		if(rci < this.data.size() && this.data.get(rci) < this.data.get(mini))
			mini = rci;
		if(mini != pi) {
			swap(mini,pi);
			downHeapify(mini);
		}
	}
}
