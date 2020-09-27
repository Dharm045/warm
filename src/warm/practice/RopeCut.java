package warm.practice;

public class RopeCut {

    public static void main(String[] args) {
        System.out.println(maxCuts(23, 12, 13, 14));

    }

    static int maxCuts(int n, int a, int b, int c) {
        if (n < 0)
            return -1;
        if (n == 0)
            return 0;
        int cuts = max(maxCuts(n - a, a, b, c), maxCuts(n - b, a, b, c), maxCuts(n - c, a, b, c));
        if (cuts == -1)
            return -1;
        return cuts + 1;

    }

    static int max(int x, int y, int z) {
        if (x > z)
            return x > y ? x : y;
        return y > z ? y : z;
    }

}
