package warm.backtracking;

/**
 * 
 * Given a NxN matrix with values 0 & 1. 0 indicates blocked & 1 indicate a
 * route. A rat has to move from 0,0 to n,n in matrix. Rate can move Down cell
 * or right cell of current cell.
 * 
 * 
 * 
 * @author dharamrajverma
 *
 */
public class RatInMaze {

    public static void main(String[] args) {
        // NxN matrix
        int n = 3;
        int maze[][] = { { 1, 1, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        RatInMaze ratInMaze = new RatInMaze();

        int resultMaze[][] = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        boolean isPathExist = ratInMaze.solveMaze(maze, n, resultMaze, 0, 0);

        System.out.println(isPathExist);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(resultMaze[i][j] + " ");
            System.out.println();
        }
    }

    private boolean solveMaze(int maze[][], int n, int resultMaze[][], int i, int j) {
        if (i == n - 1 && j == n - 1) {
            resultMaze[i][j] = 1;
            return true;
        }
        if (!isSafe(maze, n, i, j)) {
            return false;
        }
        resultMaze[i][j] = 1;
        if (solveMaze(maze, n, resultMaze, i + 1, j) == true)
            return true;
        if (solveMaze(maze, n, resultMaze, i, j + 1) == true)
            return true;
        resultMaze[i][j] = 0;
        return false;
    }

    private boolean isSafe(int[][] maze, int n, int i, int j) {
        if (i < n && j < n && maze[i][j] == 1)
            return true;
        return false;
    }

}
