/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

public class ConvertSortedList2BinarySearchTree {
    private List<ListNode> list;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        
        list = new ArrayList<ListNode>();
        ListNode node = head;
        while(node != null) {
            list.add(node);
            node = node.next;
        }
        
        return makeBST(0, list.size() - 1);
    }
    
    private TreeNode makeBST(int low, int high) {
        if(low > high) {
            return null;
        }
        int mid = (low + high) >> 1;
        TreeNode node = new TreeNode(list.get(mid).val);
        node.left = makeBST(low, mid - 1);
        node.right = makeBST(mid + 1, high);
        return node;
    }
}
