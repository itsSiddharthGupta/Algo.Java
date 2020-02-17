package problems;

import java.util.Stack;

public class TowerOfHanoi {
	private void rec(int n) {
		Stack<Integer> a = new Stack<>();
		Stack<Integer> b = new Stack<>();
		Stack<Integer> c = new Stack<>();
		for (int i = n; i > 0; i--) {
			a.push(i);
		}
		System.out.println("A : " + a + ", B : " + b + ", C : " + c);
		recHelper(n, a, b, c);
	}

	private void recHelper(int n, Stack<Integer> a, Stack<Integer> b, Stack<Integer> c) {
		if (n == 0) {
			return;
		} else if (n == 1) {
			b.push(a.pop());
		} else if (n == 2) {
			if (a.isEmpty()) // when the transfer is done
				System.out.println("A : " + a + ", B : " + b + ", C : " + c);
			else {
				c.push(a.pop());
				b.push(a.pop());
				b.push(c.pop());
			}
		} else {
			recHelper(n - 1, a, b, c);
			recHelper(n - 1, b, a, c);
		}
		return;
	}

	// if no need of stack
	protected void towerOfHanoi(int n, char origin_rod, char dest_rod, char buffer_rod) {
		if (n == 1) {
			System.out.println("Move disk 1 from rod " + origin_rod + " to rod " + dest_rod);
			return;
		}
		/* move top n - 1 disks from orIgIn to buffer, using destination as a buffer. */
		towerOfHanoi(n - 1, origin_rod, buffer_rod, dest_rod);
		/* move top from origin to destination */
		System.out.println("Move disk " + n + " from rod " + origin_rod + " to rod " + dest_rod);
		/* move top n - 1 disks from buffer to destination, using origin as a buffer. */
		towerOfHanoi(n - 1, buffer_rod, dest_rod, origin_rod);
	}

	public static void main(String[] args) {
		new TowerOfHanoi().rec(15);
	}
}
