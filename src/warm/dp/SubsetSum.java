package warm.dp;

public class SubsetSum {

    private int subSetSum(int arr[], int n, int sum) {
        int dp[] = new int[n];
        dp[0] = arr[0] == sum ? 1 : 0;
        for (int i = 1; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < i; j++) {
              
            }
        }
        return dp[n - 1];
    }

}
