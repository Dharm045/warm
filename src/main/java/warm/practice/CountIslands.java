package warm.practice;

public class CountIslands {

    public static void main(String[] args) {

        int arr[][] = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } };

        int col = 5, row = 5;

        System.out.println(new CountIslands().countIsland(arr, row, col));
    }

    private void dfs(int arr[][], int m, int n, int row, int col, boolean visited[][]) {
        visited[m][n] = true;
        int rows[] = { 0, 0, -1, 1, -1, -1, 1, 1 };
        int cols[] = { -1, 1, 0, 0, -1, 1, 1, -1 };
        for (int k = 0; k < 8; k++) {
            if (isSafe(arr, m + rows[k], n + cols[k], row, col, visited)) {
                dfs(arr, m + rows[k], n + cols[k], row, col, visited);
            }

        }
    }

    private boolean isSafe(int arr[][], int m, int n, int row, int col, boolean visited[][]) {
        return (m >= 0 && m < row && n >= 0 && n < row && arr[m][n] == 1 && visited[m][n] == false) ? true : false;
    }

    private int countIsland(int arr[][], int row, int col) {
        int count = 0;
        boolean visited[][] = new boolean[row][col];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (arr[i][j] == 1 && visited[i][j] == false) {
                    dfs(arr, i, j, row, col, visited);
                    count++;
                }
            }

        }
        return count;
    }

}
