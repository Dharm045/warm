package warm;

public class CoinChangeCount {

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3 };
        int sum = 4;

        CoinChangeCount coinChangeCount = new CoinChangeCount();
        System.out.println("ANS: " + coinChangeCount.countCombinations(arr, sum, arr.length));
    }

    private int countCombinations(int arr[], int sum, int n) {
        if (sum < 0)
            return 0;
        if (sum == 0)
            return 1;
        if (n == 0)
            return 0;
        return countCombinations(arr, sum, n - 1) + countCombinations(arr, (sum - arr[n - 1]), n);
    }

}
