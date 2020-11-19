package warm.array;

import java.util.Arrays;
import java.util.Scanner;

public class InversionOfArray {

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
                long inversion = mergeSort(arr, 0, n - 1);
                System.out.println(inversion);
            }

        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }

    static long mergeSort(int arr[], int l, int r) {
        long inversion = 0;
        if (l < r) {
            int m = (l + r) / 2;
            inversion += mergeSort(arr, l, m);
            inversion += mergeSort(arr, m + 1, r);
            inversion += merge(arr, l, m, r);
        }
        return inversion;
    }

    static long merge(int arr[], int l, int m, int r) {
        long cnt = 0;
        int i = 0, j = 0, k = l;

        int left[] = Arrays.copyOfRange(arr, l, m + 1);
        int right[] = Arrays.copyOfRange(arr, m + 1, r + 1);

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                cnt = cnt + ((m - (l + i)) + 1);
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
        return cnt;
    }

}
