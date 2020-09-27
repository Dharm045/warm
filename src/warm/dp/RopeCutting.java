package warm.dp;

import java.util.Arrays;

public class RopeCutting {

    public static void main(String[] args) {

        int n = 11;
        int set[] = { 2, 5, 3 };
        System.out.println(cutTheRope(n, set));
    }

    private static int cutTheRope(int n, int set[]) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < set.length; j++) {
                if (i - set[j] >= 0 && dp[i - set[j]] != -1) {
                    dp[i] = Math.max(dp[i], dp[i - set[j]] + 1);
                    System.out.println("in for "+i+" "+j);
                }
            }
        }
        return dp[n - 1];
    }

}
