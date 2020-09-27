package warm;

public class CountSubArraysLesserKValue {

    public static void main(String[] args) {

        int arr[] = { 1, 10, 12, 4, 5, 3, 2, 7 };
        int k = 9;
        // System.out.println(countSubArrays(arr, k));
        System.out.println(countSubArraysLessThanK(arr, k));
    }

    /**
     * O(N)3
     * 
     * Sliding window
     * 
     * @param arr
     * @param k
     * @return
     */
    private static int countSubArrays(int arr[], int k) {
        int n = arr.length;
        int count = 0;
        for (int windowSize = 1; windowSize < n; windowSize++) {
            int start = 0;
            int end = windowSize;

            while (end <= n) {
                System.out.println("windowSize " + windowSize + " start " + start + " end " + end);
                boolean allGreater = true;
                for (int i = start; i < end; i++) {
                    if (arr[i] <= k) {
                        allGreater = false;
                        break;
                    }
                }
                if (allGreater) {
                    count++;
                }
                System.out.println("count " + count);
                start++;
                end++;
            }

        }
        return count;
    }

    /**
     * Efficient solution
     */

    private static int countSubArraysLessThanK(int arr[], int k) {

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int subLength = 0;
            while (i < arr.length && arr[i] < k) {
                subLength++;
                i++;
            }
            count += (subLength * (subLength + 1)) / 2;
        }
        return count;
    }

}
