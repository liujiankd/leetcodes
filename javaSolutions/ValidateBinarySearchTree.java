/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/

public class ValidateBinarySearchTree {
    private List<Integer> inorder;
    public boolean isValidBST(TreeNode root) {
        inorder = new LinkedList<Integer>();
        inTraverse(root);
        for(int i = 1; i < inorder.size(); i++) {
            if(inorder.get(i - 1) >= inorder.get(i)) {
                return false;
            }
        }
        return true;
    }
    
    private void inTraverse(TreeNode node) {
        if(node == null) {
            return;
        }
        inTraverse(node.left);
        inorder.add(node.val);
        inTraverse(node.right);
    }
}
