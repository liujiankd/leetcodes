/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
*/

public class SumRoot2LeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return dfs(root, 0);
    }
    
    public int dfs(TreeNode node, int num) {
        num = num * 10 + node.val;
        
        if(node.left == null && node.right == null) {
            return num;
        }
        
        int leftSum = 0;
        int rightSum = 0;
        if(node.left != null) {
            leftSum = dfs(node.left, num);
        }
        if(node.right != null) {
            rightSum = dfs(node.right, num);
        }
        
        return leftSum + rightSum;
    }
}
