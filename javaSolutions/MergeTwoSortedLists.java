/* Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists. */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	// 1. At least one list is null
        if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        }
	
	// 2. Two lists are not null.
	// compare two head nodes' values, make sure l1 points to the smaller one       
        // so we just merge l2 to l1 and finally return l1.
        ListNode p1;
        if(l1.val > l2.val) {
            p1 = l1;
            l1 = l2;
            l2 = p1;
        }
        
        p1 = l1;
        ListNode p2 = l2;
        ListNode q1 = p1;
        ListNode q2 = q1;
        while(p1 != null && p2 != null) {
            while(p1 != null && p1.val <= p2.val) {
                q1 = p1;
                p1 = p1.next;
            }
            q1.next = p2;
            if(p1 == null) {
                return l1;
            }
            while(p2 != null && p2.val <= p1.val) {
                q2 = p2;
                p2 = p2.next;
            }
            q2.next = p1;
        }
        
        return l1;
    }

    private class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
	    val = x;
	    next = null;
	}
    }
}
