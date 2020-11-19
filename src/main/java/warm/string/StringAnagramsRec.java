package warm.string;

/**
 * Given a string, print all permutations
 * 
 * @author dharamrajverma
 *
 */
public class StringAnagramsRec {

    public static void main(String[] args) {
        StringAnagramsRec stringAnagramsRec = new StringAnagramsRec();
        StringBuffer str = new StringBuffer("ABC");
        stringAnagramsRec.permute(str, 0, str.length()-1);
    }

    private void permute(StringBuffer str, int l, int r) {
        if (l == r) {
            System.out.println(str);
            return;
        } else {
            for (int i = l; i <= r; i++) {
                swap(str, i, l);
                permute(str, l + 1, r);
                swap(str, i, l);
            }
        }
    }

    private void swap(StringBuffer str, int i, int l) {
        char t = str.charAt(i);
        str.setCharAt(i, str.charAt(l));
        str.setCharAt(l, t);
    }

}
