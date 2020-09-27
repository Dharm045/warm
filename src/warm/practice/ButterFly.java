package warm.practice;

import java.util.ArrayDeque;

public class ButterFly {

    public static void main(String[] args) {

        int n = 5;
        int k = 4;
        int x = 3;

        ArrayDeque<Integer> a;
        
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = k;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 2] * k) + ((dp[i - 1] - dp[i - 2]) * (k - 1));
        }
        System.out.println(dp[n]);

    }

}
