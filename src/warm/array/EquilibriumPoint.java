package warm.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EquilibriumPoint {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());

            while (--t >= 0) {
                int m = Integer.parseInt(br.readLine());

                String arr1Ele[] = br.readLine().split(" ");
                int arr1[] = new int[m];
                for (int i = 0; i < m; i++) {
                    arr1[i] = Integer.parseInt(arr1Ele[i]);
                }

                System.out.println(findEquilibrium(arr1, m));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int findEquilibrium(int[] arr1, int m) {

        if (arr1.length == 1)
            return 1;

        long sufixSum[] = new long[m];
        sufixSum[m - 1] = arr1[m - 1];
        for (int i = m - 2; i >= 0; i--) {
            sufixSum[i] = sufixSum[i + 1] + arr1[i];
        }

        long prefixSum = arr1[0];
        for (int i = 1; i < m - 1; i++) {
            if (prefixSum == (sufixSum[i + 1])) {
                return i + 1;
            }
            System.out.println(i+" "+prefixSum+" "+sufixSum[i+1]);
            prefixSum = prefixSum + arr1[i];
        }

        return -1;
    }

}
