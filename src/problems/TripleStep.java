package problems;

public class TripleStep {
	private int tripleStep(int currVal, int n) {
		if(currVal == n)
			return 1;
		if(currVal > n)
			return 0;
		return tripleStep(currVal+1, n) + tripleStep(currVal+2, n) + tripleStep(currVal+3, n);
	}
	private int tripleStepMemo(int currVal, int n, int[] memo) {
		if(currVal==n)
			return 1;
		if(currVal>n)
			return 0;
		if(memo[currVal]!=0)
			return memo[currVal];
		memo[currVal] = tripleStepMemo(currVal+1, n, memo) + tripleStepMemo(currVal+2, n, memo) + tripleStepMemo(currVal+3, n, memo);
		return memo[currVal];
	}
	private int dp(int n) {
		if(n==0)
			return 0;
		int a = 1;
		int b = 2;
		int c = 4;
		if(n==1)
			return a;
		if(n==2)
			return b;
		if(n==3)
			return c;
		for(int i = n-4;i>=0;i--) {
			int ans = a+b+c;
			a=b;
			b=c;
			c=ans;
		}
		return c;
	}
	public static void main(String[] args) {
		TripleStep ts = new TripleStep();
//		System.out.println(ts.tripleStep(0, 40));
		System.out.println(ts.tripleStepMemo(0, 3, new int[4]));
		System.out.println(ts.dp(3));
	}
}
