package problems;

public class FlipBitToWin {
	private void flipBit(int num) {
		int maxLength = 0;
		int length = 0;
		int zeroLength = 0;
		boolean redFlag = false;
		while(num > 0) {
			if((num&1) != 0) {
				length++;
				if(redFlag)
					zeroLength++;
			}else {
				if(!redFlag) {
					redFlag = true;
					length++;
				}else {
					maxLength = Math.max(maxLength, length);
					length = zeroLength+1;
					zeroLength = 0;
				}
			}
			num = num>>>1;
		}
		maxLength = Math.max(maxLength, length);
		System.out.println(maxLength);
	}
	
	public static void main(String[] args) {
		new FlipBitToWin().flipBit(1775);
	}
}
