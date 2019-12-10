package sort;

public class MergeSort {
	private void merge(int[] arr, int lo, int mid, int hi) {
		int[] temp = new int[100];
		int i = lo;
		int j = mid+1;
		int k = lo;
		while(i<=mid && j<=hi) {
			if(arr[i]<=arr[j]) {
				temp[k] = arr[i];
				i++;
				k++;
			}else {
				temp[k] = arr[j];
				j++;
				k++;
			}
		}
		while(i<=mid) {
			temp[k] = arr[i];
			k++;
			i++;
		}
		while(j<=hi) {
			temp[k] = arr[j];
			k++;
			j++;
		}
		for(i = lo;i<=hi;i++) {
			arr[i] = temp[i];
		}
	}
	
	protected void mergesort(int[] arr, int lo, int hi) {
		if(lo < hi) {
			int q = (lo+hi)/2;
			mergesort(arr, lo, q);
			mergesort(arr, q+1, hi);
			merge(arr, lo, q, hi);
		}
	}
}
