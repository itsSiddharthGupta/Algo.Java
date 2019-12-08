package string;

public class NaiveMatcher {
	protected void naive(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		for(int i = 0;i<n-m+1;i++) {
			int j = 0;
			for(j = 0;j<m;j++) {
				if(pattern.charAt(j)!=text.charAt(i+j)){
					break;
				}
			}
			if(j==m)
				System.out.println("Pattern found at shift : " + i);
		}
	}
}
