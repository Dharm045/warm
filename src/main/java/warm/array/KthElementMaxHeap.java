package warm.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://practice.geeksforgeeks.org/problems/kth-smallest-element/0
 * 
 * k size max heap
 * 
 * @author dharamrajverma
 *
 */
public class KthElementMaxHeap {

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
                System.out.println(kthElement(arr, k));
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

    private static int kthElement(int arr[], int k) {
        buildMaxHeap(arr, k);
        // System.out.println("arr 0 " + arr[0] + " " + k);
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < arr[0]) {
                // extract max
                // insert current ith element
                arr[0] = arr[k - 1];
                maxHeapify(arr, 0, k - 1);

                // insert current ele
                insert(arr, i, k);
            }
        }
        return arr[0];
    }

    static void insert(int arr[], int i, int k) {
        arr[k - 1] = arr[i];
        int p = parent(k - 1);
        int c = k - 1;
        // System.out.println(" p " + p + " c " + c);
        while (p >= 0 && arr[p] < arr[c]) {
            // System.out.println(" p " + arr[p] + " c " + arr[c]);
            int t = arr[p];
            arr[p] = arr[c];
            arr[c] = t;
            c = p;
            p = parent(p);
        }
    }

    static void buildMaxHeap(int[] arr, int k) {
        for (int i = parent(k - 1); i >= 0; i--) {
            maxHeapify(arr, i, k);
        }
    }

    static void maxHeapify(int arr[], int i, int k) {
        int largest = i;
        int left = left(i), right = right(i);
        if (left < k && arr[left] > arr[largest])
            largest = left;
        if (right < k && arr[right] > arr[largest])
            largest = right;
        // System.out.println("largest " + largest + " i " + i);
        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            maxHeapify(arr, largest, k);
        }
    }

    static int parent(int i) {
        return (i - 1) / 2;
    }

    static int left(int i) {
        return 2 * i + 1;
    }

    static int right(int i) {
        return 2 * i + 2;
    }

}
