package warm.linklist;

public class ReverseLinkedListRec {

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        //head = reverse(head, null);

        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }

    }

    private static Node reverse(Node head, Node prev, int k) {
        if (head == null) {
            return prev;
        }
        Node next = head.next;
        head.next = prev;
        return null;//reverse(next, head);
    }

    static class Node {
        int value;
        Node next;

        Node(int v) {
            value = v;
        }
    }
}
