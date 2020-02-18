package problems;

import java.util.ArrayList;
import java.util.HashMap;
/*
	Ideally, we would like to only create the unique permutations, rather than creating every permutation and
	then ruling out the duplicates.
	We can start with computing the count of each letter (easy enough to get this-just use a hash table). For a
	string such as aabbbbc, this would be:
	a->2 I b->4 I c -> l
	Let's imagine generating a permutation of this string (now represented as a hash table). The first choice we
	make is whether to use an a, b, or c as the first character. After that, we have a subproblem to solve: find all
	permutations of the remaining characters, and append those to the already picked "prefix:'
		
					P(a->2 I b->4 I c->l) = {a + P(a->l I b->4 I C->l)} +
											{b + P(a->2 I b->3 I C->l)} +
											{c + P(a->2 I b->4 I c->6)}
					P(a- >l I b- >4 I C->l) = {a + P(a->6 I b- >4 I c->l)} +
											  {b + P(a->l I b->3 I c->l)} +
											  {c + P(a->l I b->4 I c- >0)}
					P(a- >2 I b->3 I c->l) ={a + P(a->l I b- >3 I c->l)} +
											{b + P(a- >2 I b->2 I c->l)} +
											{c + P(a->2 I b->3 I c->6)}
					P(a->2 I b->4 I c ->6) = {a + P(a->l I b- >4 I c->6)} +
											 {b + P(a->2 I b->3 I c->6)}
	
	Eventually, we'll get down to no more characters remaining.*/

public class PermutationWithDups {
	private ArrayList<String> getPerms(String str){
		ArrayList<String> ans = new ArrayList<>();
		HashMap<Character, Integer> map = getFreqTable(str);
		getPerms(map, "", str.length(), ans);
		return ans;
	}

	private void getPerms(HashMap<Character, Integer> map, String prefix, int length, ArrayList<String> ans) {
		if(length==0) {
			ans.add(prefix);
			return;
		}
		for(Character cc : map.keySet()) {
			int count = map.get(cc);
			if(count>0) {
				map.put(cc, count-1);
				getPerms(map, prefix+cc, length-1, ans);
				map.put(cc, count);
			}
		}
	}

	private HashMap<Character, Integer> getFreqTable(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0;i<str.length();i++) {
			Character cc = str.charAt(i);
			if(map.containsKey(cc)) {
				map.put(cc, map.get(cc)+1);
			}else {
				map.put(cc, 1);
			}
		}
		return map;
	}
	
	public static void main(String[] args) {
		System.out.println(new PermutationWithDups().getPerms("aaabbc"));
	}
}
