package warm;

/**
 * 
 * @author dharamrajverma
 *
 */
public class TowerOfHanoi {

    public static void main(String[] args) {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        towerOfHanoi.TOH(3, 'A', 'B', 'C');
    }

    private void TOH(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println("move " + n + " " + A + " to " + C);
            return;
        }
        TOH(n - 1, A, C, B);
        System.out.println("move " + n + " " + A + " to " + C);
        TOH(n - 1, B, A, C);
    }

}
