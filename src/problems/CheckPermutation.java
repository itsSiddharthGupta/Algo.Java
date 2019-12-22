package problems;

import java.util.HashMap;

public class CheckPermutation {
	private boolean checkpermutation(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		HashMap<Character, Integer> maps1 = new HashMap<>();
		for(int i = 0;i<s1.length();i++) {
			if(maps1.containsKey(s1.charAt(i))) {
				maps1.put(s1.charAt(i), maps1.get(s1.charAt(i)) + 1);
			}else {
				maps1.put(s1.charAt(i), 1);
			}
		}
		for(int i = 0;i<s2.length();i++) {
			Character cc = s2.charAt(i);
			if(maps1.containsKey(cc)) {
				int occ = maps1.get(cc);
				if(occ == 0)
					return false;
				else {
					occ--;
					maps1.put(cc, occ);
				}
			}else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		CheckPermutation cp = new CheckPermutation();
		System.out.println(cp.checkpermutation("siddharth", "siddarth"));
	}
}
