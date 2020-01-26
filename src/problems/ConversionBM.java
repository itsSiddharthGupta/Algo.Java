package problems;

public class ConversionBM {
	private void convert(int a,int b) {
		int count = 0;
		while(a>0 || b>0) {
			int lsbA = 0, lsbB = 0;
			if(a>0) {
				lsbA = (a&1);
				a = a>>1;
			}
			if(b>0) {
				lsbB = (b&1);
				b = b>>1;
			}
			if(lsbB!=lsbA)
				count++;
		}
		System.out.println(count);
	}

	private void convertMethod2(int a, int b) {
		int change = a^b;
		int count = 0;
		while(change>0) {
			if((change&1)==1) {
				count++;
			}
			change = change>>1;
		}
		System.out.println(count);
	}
	
	public static void main(String[] args) {
		new ConversionBM().convertMethod2(29, 15);
	}
}
