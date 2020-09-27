package warm.array;

/**
 * Given an array of integers and a sum. Count number of sub sets that has sum
 * as given sum. i/p A = [10, 20,15] Sum = 25 o/p- 1
 * 
 * subsets are {}, {10}, {20}, {15}, {10,20}, {10, 15}, {15,20}, {10, 20, 15}
 * 
 * i.e. {10, 15}
 * 
 * 
 * @author dharamrajverma
 *
 */
public class SubSetSum {

    public static void main(String[] args) {
        SubSetSum subSetSum = new SubSetSum();

        int arr[] = { 10, 20, 15 };
        int sum = 12;
        System.out.println(subSetSum.subsetSum(arr, arr.length, sum));
    }

    private int subsetSum(int arr[], int n, int sum) {
        if (n == 0) {
            return sum == 0 ? 1 : 0;
        }
        // in one call do not include current element & 2nd call include
        return subsetSum(arr, n - 1, sum) + subsetSum(arr, n - 1, sum - arr[n - 1]);
    }

}
