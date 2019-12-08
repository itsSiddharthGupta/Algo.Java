package string;

public class KMP {
	protected int[] piFunction(String pattern) {
		int m = pattern.length();
		int[] arr = new int[m];
		int k = 0;
		arr[0] = 0;
		for(int i = 1;i<m;i++) {
			while(k>0 && pattern.charAt(k)!=pattern.charAt(i)) {
				k = arr[k-1];
			}
			if(pattern.charAt(k) == pattern.charAt(i)) {
				k++;
			}
			arr[i] = k;
		}
		for(int el : arr)
			System.out.print(el + " ");
		return arr;
	}
	
	protected void KMPAlgo(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		int[] pi = piFunction(pattern);
		int q = 0;
		for(int i = 0;i<n;i++) {
			while(q>0 && pattern.charAt(q)!=text.charAt(i)) {
				q = pi[q-1];
			}
			if(pattern.charAt(q)==text.charAt(i))
				q++;
			if(q==m) {
				System.out.println("Pattern found at : " + (i-m+1));
				q=pi[q-1];
			}
		}
		System.out.println("Pattern donot exist.");
	}
}
