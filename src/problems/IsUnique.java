package problems;

import java.util.HashSet;

public class IsUnique {
	private boolean isunique(String str) {
		HashSet<Character> set = new HashSet<>();
		for(int i = 0;i<str.length();i++) {
			if(set.contains(str.charAt(i)))
				return false;
			set.add(str.charAt(i));
		}
		return true;
	}
	
	private boolean isuniqueBits(String str) {
		//let us represent a flag 
		/*
		 * this flag in bits is like 000000... upto 32 i.e. 32 bit representation
		 * take an example of "abcb"
		 * 		1) 'a' => index = 0, bitIndex = 1<<0 = 000001, flag = 000001
		 * 		2) 'b' => index = 1, bitIndex = 000010, flag&bitIndex = 000000, flag = 000011
		 * 		3) 'c' => index = 2, bitIndex = 000100, flag&bitIndex = 000000, flag = 000111
		 * 		4) 'b' => index = 1, bitIndex = 000010, flag&bitIndex = 000010, return false
		 */
		int flag = 0;
		for(int i = 0;i<str.length();i++) {
			int index = str.charAt(i) - 'a';
			int bitIndex = 1 << index;
			if((flag & bitIndex)>0)
				return false;
			flag = flag|bitIndex;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new IsUnique().isuniqueBits("asdfghjklpoiuybcbbcatrewqzxcvbnm"));
	}
}
