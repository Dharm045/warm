package warm.array;

import java.util.Scanner;

public class LargestSumContiguousSubarray {

    //    int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};  ans - 7

    void maxSumArray(int a[]) {
        int max = a[0], currentMax = a[0];
        int start = 0, end = 0;
        for (int i = 1; i < a.length; i++) {
            if (currentMax < 0 && a[i] > currentMax) {
                currentMax = a[i];
                start = i;
                System.out.println("starting with index " + i + " - " + currentMax);
            } else {
                currentMax = currentMax + a[i];
            }

            if (currentMax > max) {
                max = currentMax;
                end = i;
            }
        }
        System.out.println("start-end" + start + "-" + end + "sum: " + max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = sc.nextInt();
        }
        new LargestSumContiguousSubarray().maxSumArray(a);

    }

}
