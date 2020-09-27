package warm.array;

import java.util.Scanner;

// Array must be sorted
public class CountOccurrence {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int e = sc.nextInt();
        int left = leftMostIndex(arr, e, 0, n);
        int right = rightMostIndex(arr, e, 0, n);
        System.out.println(left + " " + right + " " + (right + 1 - left));
    }

    private static int leftMostIndex(int arr[], int e, int low, int high) {
        if (low > high) {
            return -1;
        }
        int m = (low + high) / 2;
        if ((arr[m] == e && (m == 0 || arr[m - 1] != e))) {
            return m;
        }
        if (e <= arr[m]) {
            return leftMostIndex(arr, e, low, m - 1);
        }
        return leftMostIndex(arr, e, m + 1, high);

    }

    private static int rightMostIndex(int arr[], int e, int low, int high) {
        System.out.println(low + " " + high);
        if (low > high) {
            return -1;
        }
        int m = (low + high) / 2;
        if ((arr[m] == e && (m == 0 || m == arr.length -1 || arr[m + 1] != e))) {
            return m;
        }
        if (e < arr[m]) {
            return rightMostIndex(arr, e, low, m - 1);
        }
        return rightMostIndex(arr, e, m + 1, high);

    }

}
