/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while(pre.next != null && pre.next.val < x) {
            pre = pre.next;
        }
        
        ListNode node = pre;
        while(node.next != null) {
            if(node.next.val >= x) {
                node = node.next;
            } else {
                ListNode toMove = node.next;
                node.next = toMove.next;
                toMove.next = pre.next;
                pre.next = toMove;
                pre = toMove;
            }
        }
        return dummyHead.next;
    }
}
