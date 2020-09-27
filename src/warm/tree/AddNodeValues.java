package warm.tree;

public class AddNodeValues {

    class Node {
        int value;
        Node Left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node createNode(int val) {
        Node node = new Node(val);
        return node;
    }

    public int addNode(Node node, int sum) {

        if (node == null) {
            return sum;
        }

        sum += node.value;
        sum = addNode(node.Left, sum);
        sum = addNode(node.right, sum);
        return sum;
    }

    public static void main(String[] args) {
        AddNodeValues addNode = new AddNodeValues();
        Node root = addNode.createNode(2);
        root.Left = addNode.createNode(5);
        root.right = addNode.createNode(7);
        root.right.Left = addNode.createNode(3);
        System.out.println(addNode.addNode(root, 0));
    }

}
