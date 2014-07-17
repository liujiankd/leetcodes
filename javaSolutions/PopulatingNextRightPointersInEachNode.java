public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        TreeLinkNode node = root;
        TreeLinkNode n1;
        while(node != null) {
            if(node.left != null) {
                node.left.next = node.right;
            } else {
                break;
            }
            n1 = node;
            while(n1.next != null) {
                n1.right.next = n1.next.left;
                n1 = n1.next;
                n1.left.next = n1.right;
            }
            node = node.left;
        }
    }
    
    private class TreeLinkNode {
        int val;
	TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
} 
