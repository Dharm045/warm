package warm.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0
 * 
 * Given an array arr of N integers. Find the contiguous sub-array with maximum
 * sum.
 * 
 * 
 * @author dharamrajverma
 *
 */
public class KadaneAlgo {

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while (--t >= 0) {
                int n = Integer.parseInt(br.readLine());
                int arr[] = new int[n];
                String arrStr[] = br.readLine().split(" ");
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(arrStr[i]);
                }
                System.out.println(subArrayMaxSum(arr));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static long subArrayMaxSum(int arr[]) {
        long max = arr[0];
        long currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (currentSum < 0) {
                currentSum = 0;
            }
            currentSum = currentSum + arr[i];
            if (currentSum > max) {
                max = currentSum;
            }

        }
        return max;

    }

}
