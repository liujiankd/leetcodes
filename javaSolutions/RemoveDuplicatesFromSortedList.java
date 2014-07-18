/* Given a sorted linked list, delete all duplicates such that each element appear only once. */

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        ListNode n1;
        int val;
        while(node != null) {
            val = node.val;
            n1 = node.next;
            while(n1 != null && n1.val == val) {
                n1 = n1.next; // Java have no delete operation of node like c++, so we just ignore it
            }
            node.next = n1;
            node = node.next;
        }
        return head;
    }
}
