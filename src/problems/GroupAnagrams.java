package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class GroupAnagrams {
	private String getSortedString(String s) {
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
	private void groupAnagrams(String[] arr) {
		HashMap<String, LinkedList<String>> map = new HashMap<>();
		for(String s : arr) {
			String key = getSortedString(s);
			if(map.containsKey(key)) {
				map.get(key).add(s);
			}else {
				LinkedList<String> l = new LinkedList<>();
				l.add(s);
				map.put(key, l);
			}
		}
		for(String key : map.keySet()) {
			LinkedList<String> l = map.get(key);
			for(String s : l) {
				System.out.print(s + " ");
			}
		}
	}
	public static void main(String[] args) {
		String[] arr = new String[] {"arcyz","tar","at","rat","ta","crazy"};
		new GroupAnagrams().groupAnagrams(arr);
	}
}
