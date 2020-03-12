package problems;

public class SortedMerge {
	private int[] sortedMerge(int[] A, int[] B) {
		int n = A.length;
		int m = B.length;
		int lp = n-1;
		int i = n-m-1, j = m-1;
		for(;i>=0&&j>=0;) {
			if(A[i]>B[j]) {
				A[lp] = A[i];
				i--;
			}else {
				A[lp] = B[j];
				j--;
			}
			lp--;
		}
		while(i>=0) {
			A[lp] = A[i];
			lp--;
			i--;
		}
		while(j>=0) {
			A[lp] = B[j];
			lp--;
			j--;
		}
		return A;
	}
	private void print(int[] A) {
		for(int i = 0;i<A.length;i++)
			System.out.print(A[i] + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		int[] A = new int[] {1,2,3,8,10,0,0};
		int[] B = new int[] {0,9};
		SortedMerge sm = new SortedMerge();
		sm.print(sm.sortedMerge(A, B));
	}
}
