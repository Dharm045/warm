package warm.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargestFibonacciSubsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (--t >= 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			List<Integer> subSeq = fibonacciSubSequence(arr);
			for (int i : subSeq) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	static List<Integer> fibonacciSubSequence(int arr[]) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i])
				max = arr[i];
		}

		List<Integer> fab = new ArrayList<Integer>();
		fab.add(0, 0);
		fab.add(1, 1);
		for (int i = 2; fab.get(i - 1) <= max; i++) {
			fab.add(i, fab.get(i - 1) + fab.get(i - 2));
		}

		// for (int i = 0; i < fab.size(); i++) {
		// System.out.print(fab.get(i) + " ");
		// }
		// System.out.println("Fibo end");

		List<Integer> subSeq = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int index = binarySearch(fab, arr[i], 0, fab.size() - 1);
			System.out.println("final: " + arr[i] + " " + index);
			if (index != -1) {
				subSeq.add(arr[i]);
			}
		}
		return subSeq;
	}

	static int binarySearch(List<Integer> fab, int num, int start, int end) {
		System.out.println(num + " " + start + " " + end);
		if (start <= end) {
			int m = (start + end) / 2;
			if (fab.get(m) == num) {
				System.out.println(num + " " + m);
				return m;
			}
			if (num < fab.get(m))
				return binarySearch(fab, num, start, m - 1);
			else
				return binarySearch(fab, num, m + 1, end);
		}
		return -1;
	}
}
