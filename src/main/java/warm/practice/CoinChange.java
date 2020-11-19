package warm.practice;

public class CoinChange {

    public static void main(String[] args) {

       //int S[] = new int[] { 5, 6, 7, 9, 11, 12, 13, 15};
        int S[] = new int[] { 1,2,3};
        System.out.println(count(S, S.length, 4));
    }

    static long count(int S[], int m, int n) {
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
            dp[i][0] = 1;


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j >= S[i-1]) {
                    int k = j;
                    while(k >= S[i-1]) {
                        dp[i][j] = dp[i][j] + dp[i-1][k-S[i-1]];
                        k = k -S[i-1];
                    }
                }
            }
        }
        
        
        System.out.println();
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[m][n];
    }
}
