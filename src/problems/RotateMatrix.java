package problems;

public class RotateMatrix {
	private void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private boolean rotateMatrix(int[][] matrix) {
		if (matrix.length == 0 || matrix.length != matrix[0].length)
			return false;
		printMatrix(matrix);
		int n = matrix.length;
		for (int layers = 0; layers < n / 2; layers++) {
			int first = layers;
			int last = n - 1 - layers;
			for (int i = first; i < last; i++) {
				int offset = i - first; // basically moving columnwise(in a row) or rowwise(in a column)
				// temp variable for storing
				int top = matrix[first][i];
				// top->left
				matrix[first][i] = matrix[last - offset][first];
				// left->bottom
				matrix[last - offset][first] = matrix[last][last - offset];
				// bottom->right
				matrix[last][last - offset] = matrix[i][last];
				// right->top
				matrix[i][last] = top;
			}
		}
		System.out.println("==============================================");
		printMatrix(matrix);
		return true;
	}

	public static void main(String[] args) {
		int[][] matrix = {{ 5, 1, 9,11},{ 2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
		new RotateMatrix().rotateMatrix(matrix);
	}
}
