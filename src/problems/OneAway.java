package problems;

import java.util.HashMap;

public class OneAway {

	private boolean isOneEdit(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		int permission = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0;i<n;i++) {
			Character cc = str1.charAt(i);
			if(map.containsKey(cc)) {
				map.put(cc, map.get(cc)+1);
			}else {
				map.put(cc, 1);
			}
		}
		System.out.println(map);
		for(int i = 0;i<m;i++) {
			Character sc = str2.charAt(i);
			if(!map.containsKey(sc)) {
				if(n == m) {
					map.put(str1.charAt(i), map.get(str1.charAt(i))-1);
				}
				if(permission == 0)
					permission++;
				else
					return false;
			}else {
				map.put(sc, map.get(sc)-1);
			}
		}
		System.out.println(map);
		
		for(Character key : map.keySet()) {
			if(map.get(key)!=0) {
				if(permission==0)
					permission = 1;
				else
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new OneAway().isOneEdit("please", "peas"));
	}
}
