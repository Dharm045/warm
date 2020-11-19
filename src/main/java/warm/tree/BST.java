package warm.tree;

import java.util.LinkedList;

public class BST {

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 
     * @param root
     * @param data
     * @return
     */
    private Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    /**
     * 
     */
    private Node delete(Node root, int data) {
        if (root == null) {
            return null;
        }
        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            /*
             * 1. deleting node is leaf node. 2.deleting node has one child.
             */
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            /*
             * 3. deleting node having both child. Over ride deleting with successor &
             * delete successor. (moving here ceil. You can floor instead of ceil)
             * 
             */
            Node succ = findSuccessor(root);
            root.data = succ.data;
            root.right = delete(root.right, succ.data);
        }
        return root;

    }

    private Node floorInBST(Node root, int data) {
        Node result = null;
        while (root != null) {
            if (root.data == data) {
                result = root;
                break;
            } else if (data < root.data) {
                root = root.left;
            } else {
                result = root;
                root = root.right;
            }
        }
        return result;
    }

    private Node ceilInBST(Node root, int data) {
        Node result = null;
        while (root != null) {
            if (root.data == data) {
                result = root;
                break;
            } else if (data < root.data) {
                result = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return result;
    }

    private Node findSuccessor(Node root) {
        System.out.println("findSuccessor " + root.data);
        Node current = root.right;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }

    /**
     * 
     * @param root
     */
    LinkedList<Node> Q = new LinkedList<>();

    private void print(Node root) {

        Q.add(root);
        while (!Q.isEmpty()) {
            int size = Q.size();
            while (--size >= 0) {
                Node current = Q.poll();
                System.out.print(current.data + " ");
                if (current.left != null) {
                    Q.add(current.left);
                }
                if (current.right != null) {
                    Q.add(current.right);
                }
            }
            System.out.println();
        }

        // in oder
        // if (root == null)
        // return;
        // print(root.left);
        // System.out.print(root.data + " ");
        // print(root.right);

    }

    public static void main(String[] args) {
        BST bst = new BST();
        Node root = bst.insert(null, 10);
        bst.insert(root, 5);
        bst.insert(root, 7);
        bst.insert(root, 15);
        bst.insert(root, 12);
        bst.insert(root, 18);
        bst.print(root);
        System.out.println();
        System.out.println("insert 20");
        bst.insert(root, 20);
        bst.print(root);
        System.out.println();
        System.out.println("delete 20");
        // bst.delete(root, 20);
        bst.print(root);
        System.out.println();
        System.out.println("insert 2");
        bst.insert(root, 2);
        bst.print(root);
        System.out.println();
        // bst.delete(root, 5);
        bst.print(root);
        System.out.println();
        // bst.delete(root, 15);
        bst.print(root);
        System.out.println();
        System.out.println("floorInBST "+bst.floorInBST(root, 12).data);
        System.out.println("ceilInBST "+bst.ceilInBST(root, 19).data);

    }

}
