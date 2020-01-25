package problems;

public class InsertionBitMan {
	private int insertion(int n, int m, int i, int j) {
		//Suppose we have i=2,j=4. Our mask would be like 11100011 i.e. combination of 0 and 1.
		//We can create left mask i.e. by 111<<j+1 (11100000) and right mask i.e. ((1<<i)-1) i.e. 00000011 and then OR them
		int leftMask = ((~0)<<(j+1));
		int rightMask = ((1<<i)-1);
		int mask = leftMask|rightMask;
		int nCleared = n & mask;
		return nCleared|(m<<i);
	}
	public static void main(String[] args) {
		System.out.println(new InsertionBitMan().insertion(149, 7, 2, 4));
	}

}
