/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private int[] in;
    private int[] post;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        in = inorder;
        post = postorder;
        return build(0, post.length, 0, in.length);
    }
    
    private TreeNode build(int plow, int phigh, int ilow, int ihigh) {
        if(plow >= phigh) {
            return null;
        }
        
        TreeNode node = new TreeNode(post[phigh - 1]);
        for(int i = ilow; i < ihigh; i++) {
            if(in[i] == post[phigh - 1]) {
                int length = i - ilow;
                node.left = build(plow, plow + length, ilow, i);
                node.right = build(plow + length, phigh - 1, i + 1, ihigh);
            }
        }
        
        return node;
    }
}
