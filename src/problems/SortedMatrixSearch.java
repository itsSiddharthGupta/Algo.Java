package problems;

public class SortedMatrixSearch {
	private int search(int[] arr, int element) {
		int left = 0;
		int right = arr.length-1;
		while(left<right) {
			int mid = (left+right)/2;
			if(arr[mid]==element)
				return mid;
			else if(arr[mid]<element) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		if(arr[left]==element)
			return left;
		return -1;
	}
	
	protected matReturn sortedMatrixSearch(int[][] mat, int element) {
		int rows = mat.length-1;
		int cols = mat[0].length-1;
		int i = 0;
		for(;i<=rows;i++) {
			if(element==mat[i][cols])
				return new matReturn(i, cols);
			else if(element<mat[i][cols])
				break;
		}
		int ind = -1;
		if(i<=rows) {
			ind = search(mat[i], element);
			if(ind!=-1)
				return new matReturn(i, ind);
			return new matReturn(-1,-1);
		}
		return new matReturn(-1,-1);
	}
	public static void main(String[] args) {
		int[][] mat = new int[][] {{1,5,7,8},{9,10,12,13},{15,17,19,21}};
		System.out.println(new SortedMatrixSearch().sortedMatrixSearch(mat, 150));
	}
	private class matReturn{
		int row;
		int col;
		matReturn(int row, int col){
			this.row = row;
			this.col = col;
		}
		@Override
		public String toString() {
			return "{" + this.row + ", "+this.col+"}";
		}
	}
}
