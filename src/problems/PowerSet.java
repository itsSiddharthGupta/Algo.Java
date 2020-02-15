package problems;

import java.util.ArrayList;
import java.util.LinkedList;

public class PowerSet {
	public ArrayList<LinkedList<Integer>> powerSet(int[] arr){
		ArrayList<LinkedList<Integer>> sol = new ArrayList<>();
		powerSet(arr, 0, new LinkedList<>(), sol);
		return sol;
	}
	//Method 1 brute force
	private void powerSet(int[] arr, int ind, LinkedList<Integer> list, ArrayList<LinkedList<Integer>> sol) {
		if(ind == arr.length) {
			LinkedList<Integer> ll = new LinkedList<>();
			ll.addAll(list);
			sol.add(ll);
			return;
		}
		
		for(int i = ind; i<arr.length; i++) {
			Integer no = arr[i];
			list.addLast(no);
			powerSet(arr, i+1, list, sol);
			list.removeLast();
		}
		LinkedList<Integer> ll = new LinkedList<>();
		ll.addAll(list);
		sol.add(ll);
	}
	
	private ArrayList<LinkedList<Integer>> ps(int[] arr, int ind){
		if(ind == arr.length) {
			LinkedList<Integer> blank = new LinkedList<>();
			ArrayList<LinkedList<Integer>> sol = new ArrayList<>();
			sol.add(blank);
			return sol;
		}
		
		ArrayList<LinkedList<Integer>> sol = ps(arr, ind+1);
		Integer no = arr[ind];
		int size = sol.size();
		for(int i = 0;i<size;i++) {
			LinkedList<Integer> list = sol.get(i);
			LinkedList<Integer> temp = new LinkedList<>();
			temp.addAll(list);
			temp.addLast(no);
			sol.add(temp);
		}
		return sol;
	}
	
	public static void main(String[] args) {
		System.out.println(new PowerSet().powerSet(new int[]{1,2,3,4,5}).size());
		System.out.println(new PowerSet().ps(new int[] {1,2,3}, 0));
	}
}
