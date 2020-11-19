package warm.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://practice.geeksforgeeks.org/problems/number-of-pairs/0/
 * 
 * @author dharamrajverma
 *
 */

public class NoOfPairs {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());

            while (--t >= 0) {
                String len[] = br.readLine().split(" ");
                int m = Integer.parseInt(len[0]);
                int n = Integer.parseInt(len[1]);

                int arr1[] = new int[m];
                int arr2[] = new int[n];

                String arr1Ele[] = br.readLine().split(" ");
                String arr2Ele[] = br.readLine().split(" ");

                for (int i = 0; i < m; i++) {
                    arr1[i] = Integer.parseInt(arr1Ele[i]);
                }

                for (int i = 0; i < n; i++) {
                    arr2[i] = Integer.parseInt(arr2Ele[i]);
                }

                System.out.println(findPairs(arr1, arr2, m, n));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static long findPairs(int[] arr1, int[] arr2, int m, int n) {

        long pairs = 0;

        int xNon0 = 0;
        int xGreater1 = 0;
        int x2 = 0;
        int x3 = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > 0) {
                xNon0++;
            }
            if (arr1[i] > 1) {
                xGreater1++;
            }
            if (arr1[i] == 2) {
                x2++;
            }
            if (arr1[i] == 3) {
                x3++;
            }
        }

        Arrays.sort(arr2);
        int y0 = 0;
        int y1 = 0;
        int y34 = 0;
        int y2 = 0;
        int i = 0;
        while (arr2[i] <= 4) {
            if (arr2[i] == 0)
                y0++;
            if (arr2[i] == 1)
                y1++;
            if (arr2[i] == 3 || arr2[i] == 4) {
                y34++;
            }
            if (arr2[i] == 2) {
                y2++;
            }
            i++;
        }
        pairs = pairs + xNon0 * y0;
        pairs = pairs + xGreater1 * y1;
        // System.out.println(pairs);

        for (i = 0; i < arr1.length; i++) {
            if (arr1[i] != 0 && arr1[i] != 1) {
                // System.out.println(binarySearch(arr2, 0, arr2.length - 1, arr1[i]) + " " +
                // arr1[i]);
                pairs = pairs + binarySearch(arr2, 0, arr2.length - 1, arr1[i]);
            }
        }
        // System.out.println(pairs);
        // remove 2,3 pairs
        pairs = pairs - (x2 * y34);
        // add 3,2 pairs
        pairs = pairs + (x3 * y2);
        // System.out.println(pairs);

        return pairs;
    }

    private static int binarySearch(int arr2[], int l, int r, int x) {

        if (l > r) {
            return l == 0 ? arr2.length : 0;
        }

        int m = (l + r) / 2;

        if (arr2[m] == x && (m + 1) < arr2.length && arr2[m + 1] > x) {
            return arr2.length - m - 1;
        }

        if (arr2[m] < x && (m + 1) < arr2.length && arr2[m + 1] > x) {
            return arr2.length - m - 1;
        }

        if (arr2[m] <= x) {
            return binarySearch(arr2, m + 1, r, x);
        } else {
            return binarySearch(arr2, l, m - 1, x);
        }
    }

}
