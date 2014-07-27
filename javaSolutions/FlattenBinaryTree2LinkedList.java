/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
*/

public class FlattenBinaryTree2LinkedList {
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        
        List<TreeNode> preOrder = new LinkedList<TreeNode>();
        List<TreeNode> stk = new LinkedList<TreeNode>();
        stk.add(root);
        TreeNode node = null;
        int length = 0;
        while((length = stk.size()) != 0) {
            node = stk.get(length - 1);
            preOrder.add(node);
            stk.remove(length - 1);
            if(node.right != null) {
                stk.add(node.right);
            }
            if(node.left != null) {
                stk.add(node.left);
            }
        }
        
        length = preOrder.size();
        for(int i = 1; i < length; i++) {
            node = preOrder.get(i - 1);
            node.right = preOrder.get(i);
            node.left = null;
        }
        node = preOrder.get(length - 1);
        node.left = null;
        node.right = null;
    }
}
