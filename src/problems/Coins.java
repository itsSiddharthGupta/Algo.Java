package problems;

import java.util.HashMap;

public class Coins {
	//Brute Force
	private int coinsWayBF(int n) {
		if(n<0)
			return 0;
		if(n==0)
			return 1;
		return coinsWayBF(n-1) + coinsWayBF(n-5) + coinsWayBF(n-10) + coinsWayBF(n-25);
	}
	
	private int coinsWayDP(int n, HashMap<Integer, Integer> map) {
		if(n<0)
			return 0;
		if(n==0)
			return 1;
		if(map.containsKey(n) && map.get(n)>0)
			return map.get(n);
		int count = coinsWayBF(n-1) + coinsWayBF(n-5) + coinsWayBF(n-10) + coinsWayBF(n-25);
		map.put(n, count);
		return map.get(n);
	}
	public static void main(String[] args) {
		System.out.println(new Coins().coinsWayBF(70));
		System.out.println(new Coins().coinsWayDP(70, new HashMap<>()));
	}
}
