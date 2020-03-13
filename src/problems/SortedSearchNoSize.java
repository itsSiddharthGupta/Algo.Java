package problems;

public class SortedSearchNoSize {
	//Cannot use length method
	private int search(int[] arr, int element) {
		int left = 0;
		int right = 1;
		while(arr[right]!=-1&&arr[right]<element) {
			right*=2;
		}
		left = right/2;
		while(left<right) {
			int mid = (left+right)/2;
			if(arr[mid]==-1) {
				right = mid-1;
			}else if(arr[mid]==element) {
				return mid;
			}else if(arr[mid]>element) {
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
		if(arr[left]==element)
			return left;
		return -1;
	}
	public static void main(String[] args) {
		int[] arr = new int[] {1,4,6,8,15,21,25,28,30,35,40,45,50,55,60,65,-1,-1,-1,-1,-1};
		System.out.println(new SortedSearchNoSize().search(arr, 15));
	}
}
