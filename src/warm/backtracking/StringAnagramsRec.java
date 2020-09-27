package warm.backtracking;

/**
 * Given a string, print all permutations except string contain 'AB' as
 * substring
 * 
 * @author dharamrajverma
 *
 */
public class StringAnagramsRec {

    public static void main(String[] args) {
        StringAnagramsRec stringAnagramsRec = new StringAnagramsRec();
        StringBuffer str = new StringBuffer("ABC");
        stringAnagramsRec.permute(str, 0, str.length() - 1);
    }

    private void permute(StringBuffer str, int l, int r) {
        if (l == r) {
            System.out.println(str);
            return;
        } else {
            for (int i = l; i <= r; i++) {
                // Add check to ensure move will not permute AB(Backtrack in case of permutation
                // going to make a string that contains 'AB')
                if (isSafe(str, l, i, r)) {
                    swap(str, i, l);
                    permute(str, l + 1, r);
                    swap(str, i, l);
                }
            }
        }
    }

    private boolean isSafe(StringBuffer str, int l, int i, int r) {
        if (l != 0 && str.charAt(l - 1) == 'A' && str.charAt(i) == 'B')
            return false;
        if (r == l + 1 && str.charAt(l) == 'B' && str.charAt(i) == 'A') {
            return false;
        }
        return true;
    }

    private void swap(StringBuffer str, int i, int l) {
        char t = str.charAt(i);
        str.setCharAt(i, str.charAt(l));
        str.setCharAt(l, t);
    }

}
