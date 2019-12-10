package sort;

public class QuickSort {
	private int partition(int[] arr, int lo, int hi) {
		int pivot = arr[hi];
		int i = lo-1;
		for(int j = lo;j<hi;j++) {
			if(arr[j] <= pivot) {
				i++;
				//swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		//swap arr[i+1] and arr[hi]
		int temp = arr[i+1];
		arr[i+1] = arr[hi];
		arr[hi] = temp;
		return i+1;
	}
	protected void quicksort(int[] arr, int lo, int hi) {
		if(lo<hi) {
			int q = partition(arr, lo, hi);
			quicksort(arr, lo, q-1);
			quicksort(arr, q+1, hi);
		}
	}
}
