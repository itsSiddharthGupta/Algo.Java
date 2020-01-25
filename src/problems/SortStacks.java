package problems;

import java.util.Stack;

public class SortStacks {
	protected void sort(Stack<Integer> st) {
		Stack<Integer> temp = new Stack<>();
		while(!st.isEmpty()) {
			int val = st.pop();
			if(temp.isEmpty() || temp.peek()<val) {
				temp.push(val);
			}else {
				while(!temp.isEmpty() && val < temp.peek()) {
					st.push(temp.pop());
				}
				temp.push(val);
			}
		}
		while(!temp.isEmpty()) {
			st.push(temp.pop());
		}
		System.out.println(st);
	}
	public static void main(String[] args) {
		SortStacks s = new SortStacks();
		Stack<Integer> st = new Stack<>();
		st.push(3);
		st.push(1);
		st.push(4);
		st.push(5);
		System.out.println(st);
		s.sort(st);
	}
}
