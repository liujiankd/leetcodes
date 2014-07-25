/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/

public class PopulatingNextRightPointersInEachNode2 {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        
        List<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        int length = 0;
        TreeLinkNode pNode = null;
        int i = 0;
        while((length = queue.size()) != 0) {
            for(i = 0; i < length; i++) {
                pNode = queue.get(i);
                if(pNode.left != null) {
                    queue.add(pNode.left);
                }
                if(pNode.right != null) {
                    queue.add(pNode.right);
                }
                if(i + 1 < length) {
                    pNode.next = queue.get(i + 1);
                }
            }
            queue = queue.subList(length, queue.size());            
        }
    }
}
