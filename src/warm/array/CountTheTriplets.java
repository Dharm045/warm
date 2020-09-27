package warm.array;

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/count-the-triplets/0
 * 
 * @author dharamrajverma
 *
 */
public class CountTheTriplets {

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (--t >= 0) {
                int n = sc.nextInt();
                int arr[] = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                System.out.println(countTripletSum(arr));
            }

        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }

    private static int countTripletSum(int arr[]) {
        int count = 0;

        int map[] = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            map[arr[i]]++;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (map[arr[i] + arr[j]] != 0) {
                    count++;
                }
            }
        }
        return count == 0 ? -1 : count;
    }

}
