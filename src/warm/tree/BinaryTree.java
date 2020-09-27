package warm.tree;

import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Size of binary tree
    int size(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    // Max of binary tree
    int max(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data, Math.max(max(root.left), max(root.right)));
    }

    // Height of binary tree
    static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // print nodes on kth distance
    void printKDistanceNode(Node root, int k) {

        if (root == null) {
            return;
        }

        if (k == 0) {
            System.out.println("k distance node: " + root.data);
        }
        printKDistanceNode(root.left, k - 1);
        printKDistanceNode(root.right, k - 1);
    }

    // Left view of binary tree
    // Doing by pre ordr traversal. Also it can be done using level order traversal
    // line by line(iterative ).
    int maxLevelPrinted = 0;

    void leftView(Node root, int level) {
        if (root == null) {
            return;
        }
        if (maxLevelPrinted < level) {
            maxLevelPrinted = level;
            System.out.println(root.data);
        }
        leftView(root.left, level + 1);
        leftView(root.right, level + 1);
    }

    // Children checksum property
    boolean childrenCheckSum(Node root) {

        if (root == null) {
            return true;
        }

        int childValue = root.left != null ? root.left.data : 0;
        childValue += root.right != null ? root.right.data : 0;

        if (childValue != 0 && root.data != childValue) {
            System.out.println("Not fallow Children checksum property: " + root.data + " childValue: " + childValue);
            return false;
        }
        return childrenCheckSum(root.left) && childrenCheckSum(root.right);
    }

    /**
     * Tree is balanced or not. In a Balanced Binary Tree for every node, the
     * difference between heights of left subtree and right subtree should not be
     * more than one.
     * 
     * @param args
     */
    // O(n2)
    private static boolean isBalanceTreeON2(Node root) {
        if (root == null) {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return (Math.abs(leftHeight - rightHeight) <= 1) && isBalanceTreeON2(root.left) && isBalanceTreeON2(root.right);
    }

    /**
     * O(n)
     * 
     * @param root
     * @return
     */
    private static int isBalanceTree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = isBalanceTree(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = isBalanceTree(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return (Math.max(leftHeight, rightHeight)) + 1;
    }

    /**
     * max width of bt
     * 
     * level order traversal
     * 
     * @param args
     */

    private static int width(Node root) {
        if (root == null) {
            return 0;
        }
        LinkedList<Node> Q = new LinkedList<>();

        Q.push(root);

        int width = 0;
        while (!Q.isEmpty()) {
            int currentSize = Q.size();
            if (currentSize > width) {
                width = currentSize;
            }

            while (--currentSize >= 0) {
                Node current = Q.poll();
                if (current.left != null) {
                    Q.add(current.left);
                }
                if (current.right != null) {
                    Q.add(current.right);
                }
            }
        }
        return width;
    }

    /**
     * Binary tree to doubly link list
     * 
     * 
     * @param args
     */

    Node prev = null;
    Node head = null;

    private Node btToDLL(Node root) {
        if (root == null)
            return null;
        btToDLL(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        btToDLL(root.right);
        return head;
    }

    /**
     * Diameter of Binary tree
     * 
     * O(n)2
     * 
     * @param args
     * 
     */

    int diametere = 0;

    private int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        diametere = Math.max(diametere, (1 + leftHeight + rightHeight));
        // System.out.println(root.data + " diametere" + diametere + " current " +
        // leftHeight + " " + rightHeight);

        diameter(root.left);
        diameter(root.right);

        return diametere;
    }

    /**
     * Diameter of BT
     * 
     * O(N)
     * 
     * @param root
     * @return
     */
    private int heightWithDiameter(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = heightWithDiameter(root.left);
        int rightHeight = heightWithDiameter(root.right);

        diametere = Math.max(diametere, 1 + leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * Lowest common ancestor of two nodes (LCA). also you can find distance b/w tow
     * nodes using this logic.
     * 
     * @param args
     */

    private Node LCA(Node root, int value1, int value2) {
        List<Node> ancestors1 = new ArrayList<>();
        List<Node> ancestors2 = new ArrayList<>();

        findPath(root, value1, ancestors1);
        findPath(root, value2, ancestors2);
        System.out.println(" LCA ");
        Node lca = null;
        for (int i = 0; i < ancestors1.size(); i++) {
            System.out.print(ancestors1.get(i).data + " ");
        }
        System.out.println();
        for (int i = 0; i < ancestors2.size(); i++) {
            System.out.print(ancestors2.get(i).data + " ");
        }
        System.out.println();
        for (int i = 0; i < ancestors1.size(); i++) {
            Node node1 = ancestors1.get(i);
            Node node2 = null;
            if (i < ancestors2.size()) {
                node2 = ancestors2.get(i);
            }
            if (node2 != null && node1.data == node2.data) {
                lca = node1;
            }
        }
        return lca;
    }

    /**
     * 
     */
    private boolean findPath(Node root, int value, List<Node> ancestors) {
        if (root == null)
            return false;
        ancestors.add(root);
        if (root.data == value) {
            return true;
        }
        if (findPath(root.left, value, ancestors) || findPath(root.right, value, ancestors)) {
            return true;
        }
        ancestors.remove(ancestors.size() - 1);
        return false;
    }

    private int nodeCount(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + nodeCount(root.left) + nodeCount(root.right);
    }

    public static void main(String args[]) {

        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.new Node(18);
        root.left = binaryTree.new Node(4);
        root.right = binaryTree.new Node(20);
        root.left.left = binaryTree.new Node(3);
        root.left.left.left = binaryTree.new Node(10);
        root.left.left.left.left = binaryTree.new Node(50);
        root.left.right = binaryTree.new Node(5);
        root.left.right.right = binaryTree.new Node(30);
        // root.left.right.right.left = binaryTree.new Node(40);
        // root.right.left = binaryTree.new Node(1);
        // root.right.right = binaryTree.new Node(12);
        // root.right.right = binaryTree.new Node(25);
        System.out.println("Size: " + binaryTree.size(root));
        System.out.println("Max: " + binaryTree.max(root));
        System.out.println("Height: " + height(root));
        System.out.println(" K distance nodes ");
        binaryTree.printKDistanceNode(root, 2);
        System.out.println("Left view ");
        binaryTree.leftView(root, 1);
        System.out.println("Chidren checksum: " + binaryTree.childrenCheckSum(root));

        System.out.println("isBalanced: " + (isBalanceTree(root) == -1 ? false : true));
        System.out.println("Width: " + width(root));

        // DLL
        // Node head = binaryTree.btToDLL(root);
        // Node current = head;
        // System.out.println(" === BT To DLL === ");
        // while (current != null) {
        // System.out.print(current.data + "==>");
        // current = current.right;
        // }
        // System.out.println();

        System.out.println(" diameter ");
        System.out.println("diameter " + binaryTree.diameter(root));
        binaryTree.diametere = 0;
        System.out.println(
                "diametereWithHeight " + binaryTree.heightWithDiameter(root) + " diametere: " + binaryTree.diametere);
        System.out.println("LCA: " + binaryTree.LCA(root, 50, 30).data);
        System.out.println("Node count: "+binaryTree.nodeCount(root));

    }

}
