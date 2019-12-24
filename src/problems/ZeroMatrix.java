package problems;

public class ZeroMatrix {
	private void makeZero(int[][] matrix, int i, int j) {
		// making row 0
		for (int p = 0; p < matrix[0].length; p++) {
			matrix[i][p] = 0;
		}
		// making col 0
		for (int p = 0; p < matrix.length; p++) {
			matrix[p][j] = 0;
		}
	}
	//Poor method
	private void zeromatrix(int[][] matrix) {
		for(int i = 0;i<matrix.length;i++) {
			for(int j = 0;j<matrix[0].length;j++) {
				if(matrix[i][j] == 0) {
					matrix[i][j] = -101010;
				}
			}
		}
		for(int i = 0;i<matrix.length;i++) {
			for(int j = 0;j<matrix[0].length;j++) {
				if(matrix[i][j] == -101010) {
					makeZero(matrix, i,j);
					break;
				}
			}
		}
		printMatrix(matrix);
	}

	private void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("==========================");
	}

	private void zeroMatrix(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		boolean isFirstRowHas0 = false, isFirstColHas0 = false;
		for(int i = 0;i<n;i++) {
			if(matrix[i][0]==0)
				isFirstColHas0 = true;
		}
		for(int i = 0;i<m;i++) {
			if(matrix[0][i]==0)
				isFirstRowHas0 = true;
		}
		
		for(int i = 1;i<n;i++) {
			for(int j = 1;j<m;j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for(int i = 1;i<m;i++) {
			if(matrix[0][i]==0)
				nullifyColumn(matrix, i);
		}
		
		for(int i = 1;i<n;i++) {
			if(matrix[i][0]==0)
				nullifyRow(matrix, i);
		}
		System.out.println("=======++++++++++++++============");
		if(isFirstRowHas0)nullifyRow(matrix,0);
		if(isFirstColHas0)nullifyColumn(matrix,0);
		
		
		printMatrix(matrix);
	}
	
	private void nullifyRow(int[][] matrix, int i) {
		for(int p = 0;p<matrix[0].length;p++) {
			matrix[i][p]=0;
		}
		printMatrix(matrix);
	}
	
	private void nullifyColumn(int[][] matrix, int i) {
		for(int p = 0;p<matrix.length;p++) {
			matrix[p][i]=0;
		}
		printMatrix(matrix);
	}
	public static void main(String[] args) {
		int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		new ZeroMatrix().zeroMatrix(matrix);
	}
}
