package problems;

import java.util.ArrayList;

public class GetPermutation {
	private ArrayList<String> getPermutation(String str){
		if(str.length() == 0) {
			ArrayList<String> temp = new ArrayList<>();
			temp.add("");
			return temp;
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rec = getPermutation(ros);
		ArrayList<String> my = new ArrayList<>();
		for(String s : rec) {
			for(int i = 0;i<=s.length();i++) {
				String ns = s.substring(0, i) + cc + s.substring(i);
				my.add(ns);
			}
		}
		return my;
	}
	public static void main(String[] args) {
		System.out.println(new GetPermutation().getPermutation("string"));
	}
}
