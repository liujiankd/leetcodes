/* Given a binary tree, determine if it is height-balanced.
   For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1 ? true : false;
    }
    
    private int height(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        if(leftHeight == -1) {
            return -1;
        }
        int rightHeight = height(node.right);
        if(rightHeight == -1) {
            return -1;
        }
        if(Math.abs(leftHeight - rightHeight) < 2) {
            return 1 + Math.max(leftHeight, rightHeight);
        } else {
            return -1;
        }
    }
}
