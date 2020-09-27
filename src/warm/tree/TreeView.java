package warm.tree;

public class TreeView {

    Node root;

    public void add(Node root, Node node) {
        System.out.println(node + " " + root);
        if (node == null) {
            return;
        }

        if (this.root == null) {
            this.root = node;
        } else if (node.value <= root.value) {
            if (root.left == null) {
                root.left = node;
            } else {
                add(root.left, node);
            }
        } else {
            if (root.right == null) {
                root.right = node;
            } else {
                add(root.right, node);
            }
        }
    }

    static int l = 0;
    public void print(Node node) {
        if (node == null) {
            return;
        }
        print(node.left);
        l++;
        System.out.println(node.value);
        print(node.right);
    }

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
        }

    }

    public static void main(String[] args) {
        System.out.println(" ==== ");
        TreeView treeView = new TreeView();
        treeView.add(treeView.root, treeView.new Node(10));
        treeView.add(treeView.root, treeView.new Node(7));
        treeView.add(treeView.root, treeView.new Node(5));
        treeView.add(treeView.root, treeView.new Node(15));
        treeView.add(treeView.root, treeView.new Node(12));
        treeView.add(treeView.root, treeView.new Node(9));

        treeView.print(treeView.root);
        System.out.println("level "+l);

    }
}
