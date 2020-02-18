package problems;

import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = matrix.length;
        for(int i = 0;i<n;i++) {
        	for(int j = 0;j<n;j++) {
        		pq.add(matrix[i][j]);
        	}
        }
        for(int i = 1;i<k;i++) {
        	pq.poll();
        }
        return pq.poll();
    }
}
