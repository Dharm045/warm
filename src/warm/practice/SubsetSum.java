package warm.practice;

/**
 * https://practice.geeksforgeeks.org/problems/subset-sum-problem/0
 * 
 * @author dharamrajverma
 *
 */
public class SubsetSum {

    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 10 };
        System.out.println(equalPartition(arr.length, arr));
    }

    static int equalPartition(int N, int arr[]) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0)
            return 0;

        return subSetSumDP(arr, N, sum / 2);

    }

    static int subSetSumDP(int arr[], int n, int sum) {
        int dp[][] = new int[n + 1][sum + 1];

        // fill 1st row. no element in arr & sum start from 0 to sum
        for (int i = 0; i <= sum; i++) {
            dp[0][i] = 0;
        }

        //// fill 1st col. if sum is 0, then all element can produce required sum (if
        //// not selected)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i - 1]]);
                }
            }
        }

        return dp[n][sum];
    }

    static int subSetSum(int arr[], int n, int sum) {
        if (n == 0)
            return sum == 0 ? 1 : 0;
        if (subSetSum(arr, n - 1, sum) == 1)
            return 1;
        return subSetSum(arr, n - 1, sum - arr[n]);
    }

}
