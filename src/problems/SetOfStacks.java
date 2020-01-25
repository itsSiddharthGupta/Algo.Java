package problems;

import java.util.LinkedList;

public class SetOfStacks {
	private static final int THRESHOLD = 5;
	private LinkedList<Integer> stack;
	private LinkedList<LinkedList<Integer>> setofstacks;

	public SetOfStacks() {
		stack = new LinkedList<>();
		setofstacks = new LinkedList<>();
		setofstacks.addLast(stack);
	}

	public void push(Integer data) {
		LinkedList<Integer> currStack = setofstacks.peekLast();
		if (currStack.size() < THRESHOLD) {
			currStack.add(data);
		} else {
			stack = new LinkedList<Integer>();
			stack.addLast(data);
			setofstacks.addLast(stack);
		}
	}

	public Integer pop() {
		LinkedList<Integer> currStack = setofstacks.peekLast();
		if (currStack.size() != 0) {
			return currStack.removeLast();
		} else {
			setofstacks.removeLast();
			return pop();
		}
	}

	public Integer peek() {
		LinkedList<Integer> currStack = setofstacks.peekLast();
		if (currStack.size() != 0) {
			return currStack.peekLast();
		} else {
			setofstacks.removeLast();
			return peek();
		}
	}

	public Integer popAt(int index) {
		int ans = -1;
		if (index > setofstacks.size()) {
			return -1;
		} else {
			LinkedList<Integer> getStack = setofstacks.get(index - 1);
			ans = getStack.removeLast();
			while (index != setofstacks.size()) {
				LinkedList<Integer> s = setofstacks.get(index - 1);
				LinkedList<Integer> t = setofstacks.get(index);
				s.addLast(t.removeFirst());
				index++;
			}
		}
		return ans;
	}

	@Override
	public String toString() {
		return setofstacks.toString();
	}

	public static void main(String[] args) {
		SetOfStacks set = new SetOfStacks();
		set.push(1);
		set.push(2);
		set.push(3);
		set.push(4);
		set.push(1);
		set.push(9);
		set.push(10);
		set.push(1);
		set.push(2);
		set.push(3);
		set.push(4);
		set.push(1);
		set.push(9);
		set.push(10);
		System.out.println(set);
//		set.pop();
//		set.pop();
//		set.pop();
//		set.pop();
//		set.pop();
		System.out.println(set.popAt(1));
		System.out.println(set);
		System.out.println(set.peek());
	}
}
