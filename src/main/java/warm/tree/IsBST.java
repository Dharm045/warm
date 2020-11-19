package warm.tree;

public class IsBST {

    class Node {
        public Node(int val) {
            this.data = val;
        }
        int data;
        Node left;
        Node right;
        

    }
    
    private Node createNode(int val) {
        return new Node(val);
    }

    public static void main(String[] args) {
        
    }
    
}
