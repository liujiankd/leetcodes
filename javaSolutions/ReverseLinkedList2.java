/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/

public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) {
            return head;
        }
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode node = dummyHead;
        int cnt = 1;
        while(cnt < m) {
            node = node.next;
            cnt++;
        }
        
        ListNode before = node;
        node = node.next;
        ListNode node1 = node.next;
        ListNode node2 = null;
        for(cnt = m + 1; cnt <= n; cnt++) {
            node2 = node1.next;
            node1.next = node;
            node = node1;
            node1 = node2;
        }
        before.next.next = node2;
        before.next = node;
        
        return dummyHead.next;
    }
}
