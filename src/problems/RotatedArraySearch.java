package problems;

public class RotatedArraySearch {
	protected int search(int[] a, int element) {
		int len = a.length;
		int p = 0;
		if(a[0]>a[len-1]) {
			for(int i=0;i<len-1;i++) {
				p++;
				if(a[i]>a[i+1])
					break;
			}
		}
		System.out.println(p);
		int left = 0, right = len-1;
		while(left<right) {
			int mid = (left+right)/2;
			int nmid = mid+p;
			if(nmid>len-1)
				nmid-=len;
			System.out.println(nmid);
			if(a[nmid]==element)
				return nmid;
			else if(a[nmid]>element)
				right=mid-1;
			else
				left=mid+1;
		}
		if(a[left+p-len]==element)
			return left+p-len;
		return -1;
	}
	public static void main(String[] args) {
		int[] a = new int[] {15,16,19,20,25,1,3,4,5,7,10,14};
		System.out.println(new RotatedArraySearch().search(a, 25));
	}
}
