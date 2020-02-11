package problems;

public class MagicIndex {
	private int magicIndex(int[] arr) {
		if(arr.length==0)
			return -1;
		int s = 0, e = arr.length-1;
		while(s<=e) {
			int mid = (s+e)/2;
			if(arr[mid] == mid)
				return mid;
			if(arr[mid]>mid)
				e = mid-1;
			else
				s = mid+1;
		}
		return -1;
	}
	public static void main(String[] args) {
		//for duplicate elements perform linear search or faster linear search
		int[] arr = {-3,-2,-1,0,2,4,6};
		System.out.println(new MagicIndex().magicIndex(arr));
	}
}
