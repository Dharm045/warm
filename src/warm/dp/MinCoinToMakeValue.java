package warm.dp;

/**
 * Given coins and a value, you need to make the value using the minimum number
 * of coins(You can a coin any number of times). i/o coins: {25,10,5} value: 30
 * o/p: 2 i/p: {9,6,5,1} value: 11 o/p: 2
 * 
 * @author dharamrajverma
 *
 */
public class MinCoinToMakeValue {

    public static void main(String[] args) {
        int arr[] = new int[] { 9, 6, 5, 1 };
        int value = 11;
        System.out.println(minCoins(arr, value));
    }

    private static int minCoins(int arr[], int value) {
        int dp[] = new int[value + 1];
        dp[0] = 0;
        for (int i = 1; i <= value; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int ci = 0; ci < arr.length; ci++) {
                if ( arr[ci] <= i)
                    dp[i] = Math.min(dp[i], dp[i - arr[ci]]);
            }
            if (dp[i] != Integer.MAX_VALUE)
                dp[i]++;
        }
        return dp[value];
    }
}
