package warm.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    void printLevelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> Q = new LinkedList<>();
        Q.add(root);
        while (!Q.isEmpty()) {
            Node node = Q.poll();
            System.out.print(node.data +" ");
            if (node.left != null) {
                Q.add(node.left);
            }
            if (node.right != null) {
                Q.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        LevelOrderTraversal lot = new LevelOrderTraversal();

        Node root = lot.new Node(20);
        root.left = lot.new Node(10);
        root.left.right = lot.new Node(30);
        root.right = lot.new Node(50);
        root.right.left = lot.new Node(5);
        root.right.right = lot.new Node(70);

        lot.printLevelOrder(root);

    }

}
