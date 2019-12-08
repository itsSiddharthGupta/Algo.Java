package string;

public class RabinKarp {
	protected void RKMatching(String text, String pattern, int uniqD, int prime) {
		int n = text.length();
		int m = pattern.length();
		int highestPower = (int) Math.pow(uniqD, m-1)%prime;
		int pHash = 0;
		int tHash = 0;
		for(int i = 0;i<m;i++) {
			pHash = (pHash*uniqD + pattern.charAt(i))%prime;
			tHash = (tHash*uniqD + text.charAt(i))%prime;
		}
		System.out.println(pHash);
		for(int i = 0;i<=n-m;i++) {
			if(tHash == pHash) {
				System.out.println(tHash);
				int j = 0;
				for (j = 0; j < m; j++) 
                { 
                    if (text.charAt(i+j) != pattern.charAt(j)) 
                        break; 
                } 
                if (j == m) 
                    System.out.println("Pattern found at index " + i); 
			}
			if(i<n-m) {
				tHash = (uniqD*(tHash - highestPower*text.charAt(i)) + text.charAt(i+m))%prime;
				if (tHash < 0) 
	                tHash = (tHash + prime); 
			}
		}
	}
}
