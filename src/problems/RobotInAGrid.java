package problems;

import java.util.ArrayList;
import java.util.HashSet;

public class RobotInAGrid {
	//O(2^(r+c))
	private void recMethod(int[][] grid, int cr, int cc, String path) {
		int r = grid.length-1;
		int c = grid[0].length-1;
		if(cr>r || cc>c)
			return;
		if(grid[cr][cc] == -1)
			return;
		if(cr==r && cc==c) {
			System.out.println(path + "[" + cr + "," + cc + "]");
			return;
		}
		recMethod(grid, cr, cc+1, path + "[" + cr + "," + cc + "], ");
		recMethod(grid, cr+1, cc, path + "[" + cr + "," + cc + "], ");
	}
	//O(r*c)
	private void dp(int[][] grid) {
		ArrayList<Point> path = new ArrayList<>();
		HashSet<Point> failedPoints = new HashSet<>();
		if(getPath(grid, grid.length-1, grid[0].length-1, path, failedPoints)) {
			System.out.println(path);
		}
	}
	private boolean getPath(int[][] grid, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
		if(row<0 || col<0 ||grid[row][col]==-1)
			return false;
		Point pt = new Point(row, col);
		boolean isOrigin = row==0&&col==0;
		if(failedPoints.contains(pt))
			return false;
		if(isOrigin || (getPath(grid, row-1, col, path, failedPoints) || getPath(grid, row, col-1, path, failedPoints))) {
			path.add(pt);
			return true;
		}
		failedPoints.add(pt);
		return false;
	}
	private class Point{
		int r,c;
		Point(int r, int c){
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "[" + this.r + "," + this.c + "]";
		}
	}
	public static void main(String[] args) {
		int[][] grid = {{0,0,0,0},{0,-1,0,-1},{0,-1,0,0},{0,0,0,0}};
		new RobotInAGrid().recMethod(grid, 0, 0, "");
		new RobotInAGrid().dp(grid);
	}
}
