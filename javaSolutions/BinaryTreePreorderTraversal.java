/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
*/

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<TreeNode> stk = new LinkedList<TreeNode>();
        List<Integer> pre = new LinkedList<Integer>();
        TreeNode node = null;
        int length = 0;
        if(root != null) {
            stk.add(root);
        }
        while((length = stk.size()) != 0) {
            node = stk.get(length - 1);
            pre.add(node.val);
            stk.remove(node);
            if(node.right != null) {
                stk.add(node.right);
            }
            if(node.left != null) {
                stk.add(node.left);
            }
        }
        
        return pre;
    }
}
