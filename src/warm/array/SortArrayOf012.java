package warm.array;

import java.util.Scanner;

public class SortArrayOf012 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (--t >= 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // sort(arr, 2);
            // sort(arr, 1);

            dutchNationalFlagAlgo(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }

            System.out.println();
        }

    }

    private static void dutchNationalFlagAlgo(int arr[]) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                int tmp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = tmp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                int tmp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = tmp;
                high--;
            }
        }
    }

    private static void sort(int arr[], int sortNum) {
        int l = 0;
        int h = arr.length - 1;

        while (h >= 0 && arr[h] == 2) {
            h--;
        }

        while (l < h) {
            while (l < arr.length && arr[l] != sortNum)
                l++;

            while (h >= 0 && arr[h] == sortNum)
                h--;

            if (l < arr.length && h >= 0 && l < h) {
                // swap
                int tmp = arr[h];
                arr[h] = arr[l];
                arr[l] = tmp;
            }
        }
    }

}
