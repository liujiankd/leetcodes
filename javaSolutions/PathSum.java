/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        
        return getPathSum(root, 0, sum);
    }
    
    private boolean getPathSum(TreeNode node, int tmpSum, int sum) {
        tmpSum += node.val;
        if(node.left == null && node.right == null) {
            return tmpSum == sum ? true : false;
        }
        if(node.left != null && getPathSum(node.left, tmpSum, sum)) {
            return true;
        }
        if(node.right != null && getPathSum(node.right, tmpSum, sum)) {
            return true;
        }
        return false;
    }
}
