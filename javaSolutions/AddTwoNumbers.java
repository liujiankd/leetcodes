/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

public class AddTwoNumbers {
    private int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null && carry == 0) {
            return null;
        }
        
        int value = carry;
        if(l1 != null) {
            value += l1.val;
            l1 = l1.next;
        }
        if(l2 != null) {
            value += l2.val;
            l2 = l2.next;
        }
        
        ListNode node = new ListNode(value % 10);
        carry = value / 10;
        node.next = addTwoNumbers(l1, l2);
        return node;
    }
}
