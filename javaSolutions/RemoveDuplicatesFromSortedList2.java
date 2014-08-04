/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/

public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode before = dummyHead;
        while(before != null && before.next != null) {
            ListNode n1 = before.next;
            if(n1.next == null) {
                break;
            }
            
            if(n1.next.val != n1.val) {
                before = n1;
                continue;
            }
            
            while(n1.next != null && n1.next.val == n1.val) {
                n1 = n1.next;
            }
            before.next = n1.next;
        }
        
        return dummyHead.next;
    }
}
