package problems;

public class RecursiveMultiply {
	//Multiply 2 numbers without using *,/ operator in minimum steps using +,- or bit shifts
	//This method consist duplicate work so dp
	private int recursiveMultiply(int a, int b) {
		int smaller = a>b?b:a;
		int bigger = a>b?a:b;
		return recursiveMultiplyHelper(smaller, bigger);
	}
	
	private int recursiveMultiplyHelper(int smaller, int bigger) {
		if(smaller == 0) {
			return 0;
		}
		if(smaller == 1) {
			return bigger;
		}
		
		int s = smaller >> 1; // Divide by 2
		int side1 = recursiveMultiplyHelper(s, bigger);
		int side2 = side1;//if smaller is even then both sides will be equal
		if(smaller%2 == 1) { // smaller is odd then both sides will be different
			side2 = recursiveMultiplyHelper(smaller-s, bigger);
		}
		return side1+side2;
	}
	
	private int recMultiplyMemo(int a, int b) {
		int smaller = a>b?b:a;
		int bigger = a>b?a:b;
		int[] memo = new int[smaller+1];
		return recMultiplyHelperMemo(smaller, bigger, memo);
	}
	
	private int recMultiplyHelperMemo(int smaller, int bigger, int[] memo) {
		if(smaller == 0) {
			return 0;
		}else if(smaller == 1) {
			return bigger;
		}else if(memo[smaller] > 0){
			return memo[smaller];
		}
		int s = smaller >> 1;
		int side1 = recMultiplyHelperMemo(s, bigger, memo);
		int side2 = side1;
		if(smaller%2 == 1) {
			side2 = recMultiplyHelperMemo(smaller-s, bigger, memo);
		}
		memo[smaller] = side1 + side2;
		return memo[smaller];
	}
	
	//Best method:-  since there is no need to make different calls for even and odd,
	// because if we have an odd number then it is same as even number result + bigger number.
	// For ex : (15,30) => instead for (8,30) and (7,30) we know that 15/2 will give 7 and hence the result is 2*7*15 + 15
	// i.e. twice the result of number + if(no is odd) -> add big no
	// THis method is better because it does not contain any duplicate work and hence no need for memo
	private int minProduct(int a, int b) {
		int smaller = a>b?b:a;
		int bigger = a>b?a:b;
		return minProductHelper(smaller, bigger);
	}

	private int minProductHelper(int smaller, int bigger) {
		if(smaller==0)
			return 0;
		else if(smaller == 1)
			return bigger;
		int s = smaller >> 1;
		int halfProd = minProductHelper(s, bigger);
		int ans = halfProd+halfProd;
		if(smaller%2==1)
			ans+=bigger;
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new RecursiveMultiply().recursiveMultiply(250, 125));
		System.out.println(new RecursiveMultiply().recMultiplyMemo(250, 125));
		System.out.println(new RecursiveMultiply().minProduct(250, 125));
	}
}
