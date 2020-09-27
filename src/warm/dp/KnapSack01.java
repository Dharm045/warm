package warm.dp;

/**
 * i/p: v={ 10, 40, 30, 50 }, w = { 5, 4, 6, 3 }, W=10, o/p: 90 i/p:
 * v={60,100,120 }, w = { 10,20,30 }, W=50, o/p: 220
 * 
 * @author dharamrajverma
 *
 */

public class KnapSack01 {

    public static void main(String[] args) {

        int v[] = new int[] { 60, 100, 120 };
        int w[] = new int[] { 10, 20, 30 };
        int W = 50;

        System.out.println(knapsack(v, w, W, v.length));
    }

    private static int knapsack(int v[], int w[], int W, int n) {
        if (W == 0 || n == 0)
            return 0;

        if (w[n - 1] > W) {
            return knapsack(v, w, W, n - 1);
        }
        return Math.max(knapsack(v, w, W, n - 1), v[n - 1] + knapsack(v, w, W - w[n - 1], n - 1));
    }

}
