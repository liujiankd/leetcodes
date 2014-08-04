/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/

public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null || head.next == null || n == 0) {
            return head;
        }
        
        int cnt = 0;
        ListNode node = head;
        while(node != null) {
            cnt++;
            node = node.next;
        }
        
        n = n % cnt;
        if(n == 0) {
            return head;
        }
        
        ListNode head1 = head;
        node = head;
        for(int i = cnt - n; i > 1; i--) {
            node = node.next;
        }
        head = node.next;
        node.next = null;
        node = head;
        
        while(node.next != null) {
            node = node.next;
        }
        node.next = head1;
        
        return head;
    }
}
