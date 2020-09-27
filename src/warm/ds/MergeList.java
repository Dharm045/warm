package warm.ds;

public class MergeList {

    public static void main(String[] args) {

        SinglyLinkedListNode list1 = new SinglyLinkedListNode(1);
        list1.next = new SinglyLinkedListNode(2);
        list1.next.next = new SinglyLinkedListNode(3);
        list1.next.next.next = new SinglyLinkedListNode(4);
        list1.next.next.next.next = new SinglyLinkedListNode(5);

        SinglyLinkedListNode list2 = new SinglyLinkedListNode(6);
        list2.next = new SinglyLinkedListNode(7);
        list2.next.next = new SinglyLinkedListNode(8);
        list2.next.next.next = new SinglyLinkedListNode(9);

        int a = 2;
        int b = 3;

        SinglyLinkedListNode merged = merge(list1, list2, a, b);
        while (merged != null) {
            System.out.print(merged.data + " ");
            merged = merged.next;
        }

    }

    private static SinglyLinkedListNode merge(SinglyLinkedListNode list1, SinglyLinkedListNode list2, int a, int b) {

        SinglyLinkedListNode head = list1;
        if (a == 1) {
            head = list2;
        }

        SinglyLinkedListNode prevA = list1;
        int start = 1;
        while (start < a-1) {
            prevA = list1.next;
            start++;
        }

        System.out.println("prevA " + prevA.data);

        SinglyLinkedListNode list1Node = prevA.next;
        prevA.next = list2;

        while (prevA.next != null) {
            prevA = prevA.next;
        }

        System.out.println("prevA " + prevA.data);

        while (start < b) {
            System.out.println("list1Node " + list1Node.data+" start "+start);
            list1Node = list1Node.next;
            start++;
        }
        prevA.next = list1Node;
        return head;

    }

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data) {
            this.data = data;
        }

    }

}
