package warm.array;

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
 * 
 * Given an unsorted array A of size N of non-negative integers, find a
 * continuous sub-array which adds to a given number S.
 * 
 * 
 * @author dharamrajverma
 *
 */
public class SubArrayGivenSum {

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (--t >= 0) {
                int n = sc.nextInt();
                int sum = sc.nextInt();
                int arr[] = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                subArraySum(arr, sum);
            }
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }

    private static void subArraySum(int arr[], int sum) {
        int curentSum = 0, start = 0, end = 0;
        boolean found = false;
        while (end < arr.length) {
            while (end < arr.length && curentSum < sum) {
                curentSum = curentSum + arr[end];
                end++;
            }
            while (start <= end && curentSum > sum) {
                curentSum = curentSum - arr[start];
                start++;
            }
            if (curentSum == sum) {
                System.out.println((start + 1) + " " + (end));
                found = true;
                break;
            }

        }
        if (!found) {
            System.out.println("-1");
        }
    }

}
