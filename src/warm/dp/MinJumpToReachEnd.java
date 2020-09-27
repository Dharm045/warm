package warm.dp;

public class MinJumpToReachEnd {

    public static void main(String[] args) {

        int arr[] = new int[] { 3, 4, 2, 1, 2, 1 };
        System.out.println(minJunp(arr, arr.length));
    }

    private static int minJunp(int arr[], int n) {
        if (n == 1)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 2; i++) {
            if (i + arr[i] >= n - 1) {
                int result = minJunp(arr, i + 1);
                if (result != Integer.MAX_VALUE) {
                    min = Math.min(min, result + 1);
                }
            }
        }
        return min;
    }

}
