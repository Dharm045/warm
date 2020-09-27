package warm;

/**
 * Given a rope of length of n, you need to find max number of pieces you can
 * make such that length of every piece in the set {a,b,c}
 * 
 * 
 * @author dharamrajverma
 *
 */
public class RopeCutting {

    public static void main(String[] args) {
        RopeCutting recursion = new RopeCutting();
        // int n = 5;
        // int a = 2;
        // int b = 5;
        // int c = 1;
        int n = 23;
        int a = 11;
        int b = 9;
        int c = 12;
        System.out.println(recursion.maxCuts(n, a, b, c));
    }

    private int maxCuts(int n, int a, int b, int c) {
        if (n < 0) {
            return -1;
        }
        if (n == 0)
            return 0;

        int max = max(maxCuts(n - a, a, b, c), maxCuts(n - b, a, b, c), maxCuts(n - c, a, b, c));
        if (max == -1)
            return -1;
        return max + 1;
    }

    private int max(int x, int y, int z) {

        if (x > y) {
            return x > z ? x : z;
        }
        return y > z ? y : z;
    }
}
