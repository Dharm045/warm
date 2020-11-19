package warm.linklist;

public class ReverseLinkList {

    /**
     * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1
     * 
     * @param args
     */
    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        // head.next.next.next = new Node(4);

        head = reverse(head);

        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }

    }

    private static Node reverse(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node current = head;
        while (current.next != null) {
            Node tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        current.next = prev;

        return current;

    }

    static class Node {
        int value;
        Node next;

        Node(int v) {
            value = v;
        }
    }
}
