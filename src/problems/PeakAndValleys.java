package problems;

public class PeakAndValleys {
	protected void peakValley(int[] arr) {
		if(arr.length==0)
			return;
		for(int i = 0;i<arr.length;i+=2) {
			int maxInd = maxIndex(arr, i-1, i, i+1);
			if(maxInd!=i) {
				int temp = arr[i];
				arr[i] = arr[maxInd];
				arr[maxInd] = temp;
			}
		}
		for(int i = 0;i<arr.length;i++)
			System.out.print(arr[i]);
		System.out.println();
	}
	private int maxIndex(int[] arr, int prev, int curr, int next) {
		if(arr.length==0)
			return -1;
		int maxIndex = curr;
		if(prev>0 && arr[prev]>arr[curr])
			maxIndex = prev;
		if(next<arr.length && arr[next]>arr[maxIndex])
			maxIndex = next;
		return maxIndex;
	}
	public static void main(String[] args) {
		int[] arr = new int[] {5,3,1,2,3};
		new PeakAndValleys().peakValley(arr);
	}
}
