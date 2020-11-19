package warm.dp;

public class EditDistance {

    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer("SATURDAY");
        StringBuffer s2 = new StringBuffer("SUNDAY");

        // System.out.println(s1.insert(5, 'N'));

        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.editDistance(s1, s2, s1.length(), s2.length()));
    }

    // Recusrsion solution
    public int editDistance(StringBuffer s1, StringBuffer s2, int m, int n) {
        if (m == 0)
            return n;
        if (n == 0)
            return m;
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return editDistance(s1, s2, m - 1, n - 1);
        }
        return 1 + min(editDistance(s1, s2, m, n - 1), editDistance(s1, s2, m - 1, n),
                editDistance(s1, s2, m - 1, n - 1));
    }

    private int min(int x, int y, int z) {
        if (x < y) {
            return x < z ? z : z;
        }
        return y < z ? y : z;
    }

}
