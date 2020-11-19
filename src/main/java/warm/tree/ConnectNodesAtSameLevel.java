package warm.tree;

import java.util.LinkedList;
import java.util.Queue;


/**
 * https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1
 * 
 * @author dharamrajverma
 *
 */
public class ConnectNodesAtSameLevel {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(4);
        root.left.right = new Node(1);
        root.right.left = new Node(2);

        new ConnectNodesAtSameLevel().connect(root);
        inorder(root);
    }

    private static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.value + " " + ((root.nextRight == null) ? "" : root.nextRight.value));
        System.out.println();
        inorder(root.right);
    }

    void connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node leftNode = null;
            while (--size >= 0) {
                Node n = queue.poll();
                if (leftNode != null) {
                    leftNode.nextRight = n;
                }
                leftNode = n;
                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
            }
        }
    }
}

class Node {

    int value;
    Node left;
    Node right;
    Node nextRight;

    Node(int v) {
        this.value = v;
    }

}
