package warm.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://practice.geeksforgeeks.org/problems/kth-smallest-element/0
 * 
 * @author dharamrajverma
 *
 */

public class KthElementQuickSort {

    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while (--t >= 0) {
                int n = Integer.parseInt(br.readLine());
                int arr[] = new int[n];
                String ele[] = br.readLine().split(" ");
                for (int i = 0; i < ele.length; i++) {
                    arr[i] = Integer.parseInt(ele[i]);
                }
                int k = Integer.parseInt(br.readLine());
                quickSort(arr, 0, n - 1, k);
                System.out.println(arr[k - 1]);
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

    private static void quickSort(int arr[], int l, int r, int k) {
        if (l < r) {
            int pivotIndex = partition(arr, l, r);
            quickSort(arr, l, pivotIndex - 1, k);
            quickSort(arr, pivotIndex + 1, r, k);
        }
    }

    private static int partition(int[] arr, int l, int r) {

        int pivot = arr[r];
        int i = l - 1;

        for (int j = l; j <= r - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }

        // System.out.println("i " + i + " r " + r + " p " + pivot);

        int tmp = arr[i + 1];
        arr[i + 1] = pivot;
        arr[r] = tmp;

        return i + 1;
    }
}
