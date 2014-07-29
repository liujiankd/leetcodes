/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/

public class PathSum2 {
    private List<List<Integer>> res = null;
    private List<Integer> a = null;
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new LinkedList<List<Integer>>();
        a = new LinkedList<Integer>();
        if(root == null) {
            return res;
        }
        
        dfs(root, sum, 0);
        return res;
    }
    
    private void dfs(TreeNode node, int sum, int tmpSum) {
        tmpSum += node.val;
        a.add(node.val);
        if(node.left == null && node.right == null) {
            if(tmpSum == sum) {
                res.add(new LinkedList<Integer>(a));
            }
        } else {
            if(node.left != null) {
                dfs(node.left, sum, tmpSum);
            }
            if(node.right != null) {
                dfs(node.right, sum, tmpSum);
            }
        }
        a.remove(a.size() - 1);
    }
}
