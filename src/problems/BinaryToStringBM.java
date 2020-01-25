package problems;

public class BinaryToStringBM {
	private void binaryToString(double num) {
		StringBuffer sb = new StringBuffer();
		int i = 0;
		while(i<32) {
			num = num*2;
			if(num>=1) {
				num = num - 1;
				sb.append("1");
			}else {
				sb.append("0");
			}
			if(num==0.00)
				break;
			i++;
		}
		if(num!=0.00){
			System.out.println("ERROR");
		}else {
			System.out.print("0." + sb.toString());
		}
	}
	
	public static void main(String[] args) {
		new BinaryToStringBM().binaryToString(0.72);
	}
}
