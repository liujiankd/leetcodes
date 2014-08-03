/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
*/

public class ReverseNodesInK-Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k < 2) {
            return head;
        }
        
        int nodeNum = 0;
        ListNode node = head;
        while(node != null) {
            nodeNum++;
            node = node.next;
        }
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        node = dummyHead;
        for(int rnd = 0; rnd < nodeNum / k; rnd++) {
            ListNode beforeFirst = node;
            ListNode p1 = node.next;
            ListNode p2 = p1.next;
            ListNode p3 = p2.next;
            int n = k;
            while(n > 1) {
                p2.next = p1;
                p1 = p2;
                p2 = p3;
                if(p3 != null) {
                    p3 = p3.next;
                }
                n--;
            }
            
            node = beforeFirst.next;
            beforeFirst.next.next = p2;
            beforeFirst.next = p1;
        }
        
        return dummyHead.next;
    }
}
