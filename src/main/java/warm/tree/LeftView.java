package warm.tree;

import java.util.LinkedHashMap;
import java.util.Map;

public class LeftView {

    class Node {
        int value;
        Node left;
        Node right;
    }

    private Node createNode(int value) {
        Node node = new Node();
        node.value = value;
        return node;
    }

    public void leftView(Node node, int level, Map<Integer, Node> leftViewMap) {
        if (node == null) {
            return;
        }
        if (!leftViewMap.containsKey(level)) {
            leftViewMap.put(level, node);
        }
        leftView(node.left, level + 1, leftViewMap);
        leftView(node.right, level + 1, leftViewMap);
    }

    public static void main(String[] args) {
        LeftView leftView = new LeftView();
        Node root = leftView.createNode(10);
        root.left = leftView.createNode(5);
        root.right = leftView.createNode(15);
        root.right.right = leftView.createNode(20);
        root.right.left = leftView.createNode(13);
        root.right.right.right = leftView.createNode(22);
        root.left.left = leftView.createNode(7);

        Map<Integer, Node> leftViewMap = new LinkedHashMap<>();

        leftView.leftView(root, 0, leftViewMap);
        for (int level : leftViewMap.keySet()) {
            System.out.print(leftViewMap.get(level).value+ " ");
        }
    }

}
