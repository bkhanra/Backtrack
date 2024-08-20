package backtrack;

public class PrintPathInMaze {
	
	private static boolean isSafe(int[][] maze, int x, int y, boolean[][] visited) {
        int n = maze.length;
        return (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1 && !visited[x][y]);
    }

    // Recursive utility function to find all paths
    private static void findPaths(int[][] maze, int x, int y, int[][] path, boolean[][] visited, int n) {
        // Base Case: if destination is reached
        if (x == n - 1 && y == n - 1) {
            path[x][y] = 1;
            printPath(path, n);
            path[x][y] = 0;
            return;
        }

        // Mark this cell as visited and part of the current path
        visited[x][y] = true;
        path[x][y] = 1;

        // Move to the top cell
        if (isSafe(maze, x - 1, y, visited)) {
            findPaths(maze, x - 1, y, path, visited, n);
        }

        // Move to the down cell
        if (isSafe(maze, x + 1, y, visited)) {
            findPaths(maze, x + 1, y, path, visited, n);
        }

        // Move to the left cell
        if (isSafe(maze, x, y - 1, visited)) {
            findPaths(maze, x, y - 1, path, visited, n);
        }

        // Move to the right cell
        if (isSafe(maze, x, y + 1, visited)) {
            findPaths(maze, x, y + 1, path, visited, n);
        }

        // Backtrack: unmark this cell as part of the path and visited
        visited[x][y] = false;
        path[x][y] = 0;
    }

    // Utility function to print the path in the desired format
    private static void printPath(int[][] path, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(path[i][j] + " ");
            }
        }
        System.out.println();
    }

    // Main method to solve the problem
    public static void ratInAMaze(int[][] maze, int n) {
        int[][] path = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        findPaths(maze, 0, 0, path, visited, n);
    }

	public static void main(String[] args) {
		int[][] maze = {{1,1,0},{1,1,0},{1,1,1}};
		ratInAMaze(maze,3);

	}

}
