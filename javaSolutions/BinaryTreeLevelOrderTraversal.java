/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/
import java.util.List;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root == null) {
            return res;
        }
        
        List<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode node = null;
        List<Integer> list = null;
        int length = 0;
        int index = 0;
        while((length = queue.size()) != 0) {
            list = new LinkedList<Integer>();
            for(index = 0; index < length; index++) {
                node = queue.get(index);
                list.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            queue = queue.subList(length, queue.size());
            res.add(list);
        }
        return res;
    }
}
