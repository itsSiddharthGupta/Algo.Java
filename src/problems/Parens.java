package problems;

import java.util.ArrayList;

public class Parens {
	//recursive way
	private ArrayList<String> getParens(int n){
		ArrayList<String> ans = new ArrayList<>();
		if(n==0) {
			ans.add("");
			return ans;
		}
		ArrayList<String> rec = getParens(n-1);
		for(String s : rec) {
			String brac = "()";
			for(int i = 0;i<=s.length();i++) {
				String an = s.substring(0,i) + brac + s.substring(i);
				if(!ans.contains(an)) {
					ans.add(an);
				}
			}
		}
		return ans;
	}
	
	//efficient way
	private ArrayList<String> getPermBetterWay(int n){
		char[] arr = new char[2*n];
		ArrayList<String> ans = new ArrayList<>();
		getPerm(ans, n, n, arr,0);
		return ans;
	}
	
	private void getPerm(ArrayList<String> ans, int left, int right, char[] arr, int index) {
		if(left<0 || right<left)//invalid state
			return;
		if(left==0 && right==0) {
			ans.add(String.copyValueOf(arr));
			return;
		}
		else {
			arr[index] = '(';
			getPerm(ans, left-1, right, arr, index+1);
			
			arr[index] = ')';
			getPerm(ans, left, right-1, arr, index+1);
		}
	}

	public static void main(String[] args) {
		System.out.println(new Parens().getParens(10));
		System.out.println("=============================");
		System.out.println(new Parens().getPermBetterWay(10));
	}
}
