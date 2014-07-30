/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root == null) {
            return res;
        }
        
        List<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        TreeNode node = null;
        int length = 0;
        int count = 0;
        while((length = list.size()) != 0) {
            List<Integer> order = new LinkedList<Integer>();
            for(int i = 0; i < length; i++) {
                node = list.get(i);
                order.add(node.val);
                if(node.left != null) {
                    list.add(node.left);
                }
                if(node.right != null) {
                    list.add(node.right);
                }
            }
            count++;
            if(count % 2 == 0) {
                int len = order.size();
                for(int i = 0; i < len / 2; i++) {
                    int tmp = order.get(i);
                    order.set(i, order.get(len - 1 - i));
                    order.set(len - 1 - i, tmp);
                }
            }
            res.add(order);
            list = list.subList(length, list.size());
        }
        
        return res;
    }
}
