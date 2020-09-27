package warm.array;

import java.util.Scanner;

// Array must be sorted

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int e = sc.nextInt();
            System.out.println(bs.binarySearch(arr, e, 0, n));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int binarySearch(int arr[], int e, int low, int high) {
        if (low < high) {
            return -1;
        }

        int m = (low + high) / 2;
        if (arr[m] == e) {
            return m;
        } else if (e > arr[m]) {
            return binarySearch(arr, e, m + 1, high);
        } else {
            return binarySearch(arr, e, low, m - 1);
        }
    }

}
