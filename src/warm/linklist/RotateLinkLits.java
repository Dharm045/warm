package warm.linklist;

/**
 * https://practice.geeksforgeeks.org/problems/rotate-a-linked-list/1
 * 
 * @author dharamrajverma
 *
 */

public class RotateLinkLits {

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);

        head = rotate(head, 1);

        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }

    }

    private static Node rotate(Node head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        while (--k > 0) {
            current = current.next;
        }

        Node kthPrevNode = current;
        if (current != null) {
            while (current.next != null) {
                current = current.next;
            }
            current.next = head;
        }

        Node kthNode = kthPrevNode.next;
        kthPrevNode.next = null;
        return kthNode;
    }

    static class Node {
        int value;
        Node next;

        Node(int v) {
            value = v;
        }
    }
}
