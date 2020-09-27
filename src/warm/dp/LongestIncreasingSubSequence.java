package warm.dp;

public class LongestIncreasingSubSequence {

    public static void main(String[] args) {
        LongestIncreasingSubSequence l = new LongestIncreasingSubSequence();
        int arr[] = new int[] { 50, 60, 2, 5, 9, 10, 1 };

        System.out.println(l.liss(arr));
    }

    private int liss(int arr[]) {
        int result[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int j = 0, max = 0;
            while (j < i) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, result[j]);
                }
                j++;
            }
            result[i] = max + 1;
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, result[i]);
        }
        return max;
    }
}
