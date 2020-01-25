package problems;

public class NextNumberBM {
	private int nextBiggerNo(int num) {
		int posFlip01 = -1;
		int posFlip10 = -1;
		boolean redFlag = false;
		int dum = num;
		int i = 0;
		while(dum>0) {
			if((dum&1)!=0) {
				posFlip10 = i;
			}else {
				if(posFlip10!=-1) {
					posFlip01 = i;
					redFlag = true;
				}
			}
			if(redFlag)
				break;
			i++;
			dum = dum>>>1;
		}
		if(posFlip01==-1) {
			num = num<<1;
			num = num|1;
			num = num&(~(1<<posFlip10));
		}else {
			num = num&(~(1<<posFlip10));
			num = num|(1<<posFlip01);
		}
		return num;
	}
	private int nextSmallerNo(int num) {
		int posFlip01 = -1;
		int posFlip10 = -1;
		boolean redFlag = false;
		int dum = num;
		int i = 0;
		while(dum>0) {
			if((dum&1)==0) {
				posFlip01 = i;
			}else {
				if(posFlip01!=-1) {
					posFlip10 = i;
					redFlag = true;
				}
			}
			if(redFlag)
				break;
			i++;
			dum = dum>>>1;
		}
		if(posFlip01==-1) {
			return Integer.MIN_VALUE;
		}else {
			num = num&(~(1<<posFlip10));
			num = num|(1<<posFlip01);
		}
		return num;
	}
	
	private void nextAndPrev(int num) {
		System.out.println("Next Big One : "+nextBiggerNo(num));
		System.out.println("Next Small One : " + nextSmallerNo(num));
	}
	public static void main(String[] args) {
		new NextNumberBM().nextAndPrev(7);
	}
}
