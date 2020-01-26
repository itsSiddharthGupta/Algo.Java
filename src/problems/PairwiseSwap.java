package problems;

public class PairwiseSwap {
	private void pairwiseSwap(int num) {
		//create odd and shift it right : use mask 101010...10 i.e. 0xaaaaaaaa
		//create even and shift it left : use mask 010101...01 i.e. 0x55555555
		//merge both using OR
		System.out.println(((num&0xaaaaaaaa)>>>1) | ((num&0x55555555)<<1));
	}
	public static void main(String[] args) {
		new PairwiseSwap().pairwiseSwap(14);
	}
}
