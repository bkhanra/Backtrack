package backtrack;

public class Maze {
	
	public static boolean ratIntMaze(int maze[][]) {
		int n = maze.length;
		int[][] path = new int[n][n];
		return solveMaze(maze,0,0,path);
		
		
		
	}
	
	public static boolean solveMaze(int[][] maze, int i, int j, int[][] path) {
		//check if i, j cell is valid
		int n = maze.length;
		if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j]==0 || path[i][j]==1) {
			return false;
		}
		
		if(i==n-1 && j==n-1){
			
			return true;
		}
		
		
	}

	public static void main(String[] args) {
		int[][] maze = {{1,1,0},{1,1,0},{1,1,1}};
		boolean pathPossible = ratIntMaze(maze);
		System.out.println(pathPossible);

	}

}
