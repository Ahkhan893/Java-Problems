package LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;  // Initially, previous is null
        ListNode curr = head;  // Start with the head node // 1

        while (curr != null) {
            //1-->2-->3-->4-->5
            ListNode next = curr.next;  // Save next node // next = 2 // next == 3 // next 4
            curr.next = prev;           // Reverse the link // 1.next == null //  2.next ==  1 // 3.next = 2
            prev = curr;                // Move prev to current  // prev == 1 // prev == 2 // prev == 3
            curr = next;                 // Move curr to next  // curr = 2 // curr == 3 // curr = 4
                                         //1 (reversed) 2 → 3 → 4 → 5 // 2-->1(reversed)3 --> 4 --> 5 // 3-->2-->1(reversed) 4 --> 5
        }

        return prev;  // New head of reversed list
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        ListNode reversedHead = reverseList(head);

        System.out.println("Reversed List:");
        printList(reversedHead);
    }
}
