package problems;

public class SparseSearch {
	private int sparseSearch(String[] arr, String element) {
		int left = 0;
		int right = arr.length-1;
		while(left<right) {
			int mid = (left+right)/2;
			System.out.println("original: " + mid);
			if(arr[mid].equals("")) {
				int l = mid-1;
				int r = mid+1;
				while(true) {
					if(l<left || r>right)
						return -1;
					else if(r<=right && !arr[r].isEmpty()) {
						mid = r;
						break;
					}else if(l>=left && !arr[l].isEmpty()) {
						mid = l;
						break;
					}
					l--;
					r++;
				}
			}
			if(arr[mid].equals(element)) {
				return mid;
			}else if(arr[mid].compareTo(element)==-1) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		if(arr[left].equals(element))
			return left;
		return -1;
	}
	public static void main(String[] args) {
		String[] arr = new String[] {"at","","","","ball","","","car","","","dad","",""};
		System.out.println(new SparseSearch().sparseSearch(arr, "ball"));
	}
}
