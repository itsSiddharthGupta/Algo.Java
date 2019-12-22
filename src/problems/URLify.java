package problems;

public class URLify {

	private String urlify(String s) {
		for(int i = 0;i<s.length();i++) {
			if(s.charAt(i)==32) {
				s = (s.substring(0,i) + "%20" + s.substring(i+1));
			}
		}
		return s;
	}
	
	public static void main(String[] args) {
		System.out.println(new URLify().urlify(" "));
	}
}
