/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        List<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int length = 0;
        int level = 1;
        TreeNode node = null;
        while((length = queue.size()) != 0) {
            for(int i = 0; i < length; i++) {
                node = queue.get(i);
                if(node.left == null && node.right == null) {
                    return level;
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
            queue = queue.subList(length, queue.size());
        }
        return level;
    }
}
