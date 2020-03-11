package sorting;

public class SortingAlgos {
	private void printArr(int[] arr) {
		for(int i = 0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	protected int[] bubbleSort(int[] arr) {
		for(int pass = arr.length-1;pass>=0;pass--) {
			for(int j = 0;j<=pass-1;j++) {
				if(arr[j] >= arr[j+1]) {
					swap(arr, j, j+1);
				}
			}
		}
		return arr;
	}
	protected int[] modBubbleSort(int[] arr) {
		int flag = 1;
		for(int pass = arr.length-1;pass>=0 && flag==1;pass--) {
			flag = 0;
			for(int j=0;j<pass;j++) {
				if(arr[j] >= arr[j+1]) {
					swap(arr, j, j+1);
					flag=1;
				}
			}
		}
		return arr;
	}
	protected int[] selectionSort(int[] arr) {
		for(int i = 0;i<arr.length;i++) {
			int min = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[min])
					min=j;
			}
			swap(arr, min, i);
		}
		return arr;
	}
	protected int[] insertionSort(int[] arr) {
		for(int i = 1;i<arr.length;i++) {
			int key = arr[i];
			int j = i;
			while(arr[j-1]>key && j>=1) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = key;
		}
		return arr;
	}
	protected int[] shellSort(int[] arr) {
		for(int gap = arr.length/2;gap>0;gap/=2) {
			for(int i = gap;i<arr.length;i++) {
				int key = arr[i];
				int j = i;
				while(arr[j-gap]>key && j>=gap) {
					arr[j] = arr[j-1];
					j-=gap;
				}
				arr[j] = key;
			}
		}
		return arr;
	}
	protected int[] countingSort(int[] arr, int range) {
		int[] sort = new int[arr.length];
		int[] count = new int[range];
		for(int i = 0;i<arr.length;i++) {
			++count[arr[i]];
		}
		for(int i = 1;i<range;i++) {
			count[i] += count[i-1];
		}
		for(int i = arr.length-1;i>=0;i--) {
			sort[count[arr[i]]-1] = arr[i];
			--count[arr[i]];
		}
		return sort;
	}
	public static void main(String[] args) {
		SortingAlgos algo = new SortingAlgos();
		int[] arr = new int[] {9,8,7,6,5,4,3,2,1};
		algo.printArr(algo.bubbleSort(arr));
		algo.printArr(algo.selectionSort(arr));
		algo.printArr(algo.insertionSort(arr));
		algo.printArr(algo.shellSort(arr));
		algo.printArr(algo.countingSort(arr, 10));
	}
}
