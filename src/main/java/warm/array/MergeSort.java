package warm.array;

import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {

        MergeSort mergeSort = new MergeSort();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        mergeSort.mergeSort(arr, 0, n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    private void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            System.out.println(l+" "+m+ " "+r+" index");
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(int arr[], int l, int m, int r) {
        System.out.println(l+" "+m+ " "+r+" index merge");
        int nl = m - l + 1;
        int nr = r - m;
        int L1[] = new int[nl];
        int R1[] = new int[nr];

        for (int i = l; i <= m; i++)
            L1[i - l] = arr[i];
        for (int i = m+1; i <= r; i++) {
            System.out.println(i+" R1 "+R1.length);
            R1[i - (m + 1)] = arr[i];
            
        }

        int i = 0;
        int j = 0;
        int k = 0;
        System.out.println(nl+" "+nr+" n");
        while (i < nl && j < nr) {
            System.out.println(i+" "+j);
            if (L1[i] <= R1[j]) {
                arr[k] = L1[i];
                i++;
                k++;
            } else {
                arr[k] = R1[j];
                j++;
                k++;
            }
        }

        while (i < nl) {
            arr[k] = L1[i];
            i++;
            k++;
        }

        while (j < nr) {
            arr[k] = R1[j];
            j++;
            k++;
        }
    }

}
