package problems;

public class StringRotation {
	//Can only use Assume you have a method isSubstring which checks if one word is a substring
	//of another. Given two strings, si and s2, write code to check if s2 is a rotation of s1 using only one
	//call to isSubstring [e.g., "water b o t t l e " is a rotation o P ' e r b o t t l e w a t " ) ,
	private boolean isStringRotation(String s1, String s2) {
		StringBuffer sb = new StringBuffer(s2);
		sb.append(s2);
		return sb.toString().contains(s1);
	}
	public static void main(String[] args) {
		System.out.println(new StringRotation().isStringRotation("waterbottle", "erbottlewater"));
	}
}
