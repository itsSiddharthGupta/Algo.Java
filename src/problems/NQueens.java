package problems;

import java.util.LinkedList;

public class NQueens {
	private class Position{
		int row;
		int col;
		Position(int row, int col){
			this.row = row;
			this.col = col;
		}
		@Override
		public String toString() {
			return "{" + this.row + " , " + this.col + "}";
		}
	}
	
	protected void nqueens(int nq, int row, boolean[][] board, LinkedList<Position> list) {
		int cols = board[0].length;
		if(nq==0) {
			System.out.println(list);
			return;
		}
		for(int i = 0;i<cols;i++) {
			if(vertical(row, i, board) && diagonal(row, i, board)) {
				board[row][i] = true;
				list.addLast(new Position(row,i));
				nqueens(nq-1, row+1, board, list);
				list.removeLast();
				board[row][i] = false;
			}
		}
	}
	
	private boolean vertical(int row, int col, boolean[][] board) {
		for(int i=0;i<row;i++) {
			if(board[i][col])
				return false;
		}
		return true;
	}
	private boolean diagonal(int row, int col, boolean[][] board) {
		for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--) {
			if(board[i][j])
				return false;
		}
		for(int i=row-1,j=col+1;i>=0&&j<board[0].length;i--,j++) {
			if(board[i][j])
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		new NQueens().nqueens(8, 0, new boolean[8][8], new LinkedList<>());
	}
}
