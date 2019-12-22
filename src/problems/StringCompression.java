package problems;

public class StringCompression {

	private String stringcompression(String str) {
		String ans = "";
		int count = 0;
		for(int i = 0;i<str.length();i++) {
			count++;
			if(i == str.length()-1) {
				ans += ""+ str.charAt(i) + count;
				count=0;
				break;
			}
			if(str.charAt(i) != str.charAt(i+1)) {
				ans += "" + str.charAt(i) + count;
				count = 0;
			}
		}
		return (str.length()>ans.length())?ans:str;
	}
	public static void main(String[] args) {
		System.out.println(new StringCompression().stringcompression("abcddddddddddddddddddde"));
	}

}
