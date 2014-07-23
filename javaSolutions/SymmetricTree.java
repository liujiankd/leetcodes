/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
*/

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        List<TreeNode> left = new LinkedList<TreeNode>();
        List<TreeNode> right = new LinkedList<TreeNode>();
        left.add(root.left);
        right.add(root.right);
        TreeNode a = null;
        TreeNode b = null;
        int length = 0;
        while((length = left.size()) != 0) {
            for(int i = 0; i < length; i++) {
                a = left.get(i);
                b = right.get(i);
                if((a == null && b != null) || (a != null && b == null)) {
                    return false;
                }
                if(a != null && b != null) {
                    if(a.val != b.val) {
                        return false;
                    } else {
                        left.add(a.left);
                        left.add(a.right);
                        right.add(b.right);
                        right.add(b.left);
                    }
                }
            }
            left = left.subList(length, left.size());
            right = right.subList(length, right.size());
        }
        
        return true;
    }

}
