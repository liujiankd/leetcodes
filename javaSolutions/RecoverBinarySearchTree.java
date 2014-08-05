/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
*/

public class RecoverBinarySearchTree {
    private List<TreeNode> inorder;
    private int length;
    public void recoverTree(TreeNode root) {
        inorder = new LinkedList<TreeNode>();
        inorderTraverse(root);
        length = inorder.size();
        if(length < 2) {
            return;
        }
        
        recover();
    }
    
    private void recover() {
        int start = 0;
        while(start < length - 1) {
            if(inorder.get(start).val > inorder.get(start + 1).val) {
                break;
            }
            start++;
        }
        int first = start++;
        int value = inorder.get(first).val;
        while(start < length) {
            if(value < inorder.get(start).val) {
                break;
            }
            start++;
        }
        TreeNode node1 = inorder.get(first);
        TreeNode node2 = inorder.get(start - 1);
        node1.val = node2.val;
        node2.val = value;
    }
    
    private void inorderTraverse(TreeNode node) {
        if(node == null) {
            return;
        }
        inorderTraverse(node.left);
        inorder.add(node);
        inorderTraverse(node.right);
    }
}
