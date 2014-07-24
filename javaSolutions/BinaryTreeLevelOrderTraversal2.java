/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/

public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
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
            res.addFirst(list);
            queue = queue.subList(length, queue.size());
        }
        
        // length = res.size();
        // for(index = 0; index < length / 2; index++) {
        //     list = res.get(index);
        //     res.set(index, res.get(length - 1 - index));
        //     res.set(length - 1 - index, list);
        // }
        return res;
    }
}
