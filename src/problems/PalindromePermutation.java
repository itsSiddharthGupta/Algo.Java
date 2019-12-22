package problems;

public class PalindromePermutation {
	
	private boolean isPalindromePermutation(String s) {
		int[] arr = new int[26];
		for(int i = 0;i<s.length();i++) {
			char cc = s.charAt(i);
			arr[cc - 'a']++;
		}
		
		int flagForOdd = 0;
		for(int i = 0;i<26;i++) {
			if(s.length()%2 == 0) {//even length
				if(arr[i]%2 != 0)
					return false;
			}else {
				if(arr[i]%2 != 0) {
					if(flagForOdd == 0)
						flagForOdd = 1;
					else
						return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new PalindromePermutation().isPalindromePermutation("aabbccddde"));
	}
}
