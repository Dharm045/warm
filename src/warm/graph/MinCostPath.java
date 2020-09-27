package warm.graph;

/**
 * https://www.geeksforgeeks.org/min-cost-path-dp-6/
 * 
 * @author dharamrajverma
 *
 */
public class MinCostPath {

    public static void main(String[] args) {
        int costMatrix[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

        MinCostPath minCostPath = new MinCostPath();
        System.out.println(minCostPath.minCost(costMatrix, 3, 3));

    }

    private int minCost(int costMatrix[][], int m, int n) {

        int tc[][] = new int[m][n];

        tc[0][0] = costMatrix[0][0];
        for (int i = 1; i < m; i++) {
            tc[i][0] = tc[i - 1][0] + costMatrix[i][0];
        }

        for (int j = 1; j < n; j++) {
            tc[0][j] = tc[0][j - 1] + costMatrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                tc[i][j] = min(tc[i - 1][j - 1], tc[i - 1][j], tc[i][j - 1]) + costMatrix[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(tc[i][j] + " ");
            System.out.println();
        }

        return tc[m-1][n-1];
    }

    private int min(int x, int y, int z) {
        if (x < y) {
            return x < z ? x : z;
        }
        return y < z ? y : z;
    }

}
