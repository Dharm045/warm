package warm.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays/0/
 * 
 * @author dharamrajverma
 *
 */
public class MergeSortedArray {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int t = Integer.parseInt(br.readLine());

            while (--t >= 0) {

                String[] mn = br.readLine().split(" ");
                int m = Integer.parseInt(mn[0]);
                int n = Integer.parseInt(mn[1]);

                int arr1[] = new int[m];
                int arr2[] = new int[n];

                String arrEle[] = br.readLine().split(" ");

                for (int i = 0; i < m; i++) {
                    arr1[i] = Integer.parseInt(arrEle[i]);
                }

                String arrEle2[] = br.readLine().split(" ");
                for (int i = 0; i < n; i++) {
                    arr2[i] = Integer.parseInt(arrEle2[i]);
                }

                merge(arr1, arr2);

                for (int i = 0; i < arr1.length; i++) {
                    System.out.print(arr1[i] + " ");
                }

                for (int i = 0; i < arr2.length; i++) {
                    System.out.print(arr2[i] + " ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void merge(int arr1[], int arr2[]) {
        int m = arr1.length;
        int n = arr2.length;

        for (int i = n - 1; i >= 0; i--) {
            int last = arr1[m - 1];
            if (arr2[i] > last) {
                continue;
            }
            int j = m - 2;
            while (j >= 0 && arr1[j] > arr2[i]) {
                arr1[j + 1] = arr1[j];
                j--;
            }

            j = j < 0 ? 0 : j + 1;
            arr1[j] = arr2[i];
            arr2[i] = last;
        }
    }
}
