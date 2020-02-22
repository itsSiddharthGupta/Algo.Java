package problems;

public class ContiguousBoxes {
	private int maxHt(int[] ht, int[] w, int[] d, int h, int ind) {
		if(ind>=d.length || w[ind] > w[ind-1] || d[ind] > d[ind-1])
			return h;
		return maxHt(ht,w,d,h+ht[ind], ind+1);
	}
	
	protected void maxRec(int[] ht, int[] w, int[] d) {
		int maxHt = -1;
		for(int i = 1;i<ht.length;i++) {
			maxHt = Math.max(maxHt, maxHt(ht, w, d, ht[i-1], i));
		}
		System.out.println(maxHt);
	}
	
	protected void maxItr(int[] ht, int[] w, int[] d) {
		int maxHt = -1;
		for(int i = 0;i<ht.length;i++) {
			int tempHt = ht[i];
			for(int j = i+1;j<ht.length;j++) {
				if(w[j]>w[j-1] || d[j]>d[j-1])
					break;
				tempHt+=ht[j];
			}
			maxHt = Math.max(maxHt, tempHt);
		}
		System.out.println(maxHt);
	}
	
	public static void main(String[] args) {
		ContiguousBoxes sob = new ContiguousBoxes();
		sob.maxRec(new int[] {8,10,6,15,10}, new int[] {3,6,4,2,3}, new int[] {2,8,6,3,1});
		sob.maxItr(new int[] {8,10,6,15,10}, new int[] {3,6,4,2,3}, new int[] {2,8,6,3,1});
	}
}
