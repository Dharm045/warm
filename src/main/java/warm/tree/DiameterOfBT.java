package warm.tree;

public class DiameterOfBT {
    static int max = 0;

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(4);
        root.left.right = new Node(1);
        root.left.right.right = new Node(10);
        root.left.right.right.right = new Node(11);
        root.left.left.left = new Node(9);
        // root.right.left = new Node(2);

        new DiameterOfBT().diameterRec(root);
        System.out.println(max);

    }

    int diameterRec(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            max = Math.max(max, 1);
            return 1;
        }
        int l = diameterRec(root.left);
        int r = diameterRec(root.right);

        int dia = 1 + Math.max(l, r);
        max = Math.max(max, 1 + l + r);
        return dia;
    }

}
