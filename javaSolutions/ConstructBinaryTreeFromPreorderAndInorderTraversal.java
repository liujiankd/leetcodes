/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int[] pre;
    private int[] in;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        in = inorder;
        return build(0, pre.length, 0, in.length);
    }
    
    private TreeNode build(int plow, int phigh, int ilow, int ihigh) {
        if(plow >= phigh) {
            return null;
        }
        
        TreeNode node = new TreeNode(pre[plow]);
        for(int i = ilow; i < ihigh; i++) {
            if(in[i] == pre[plow]) {
                int length = i - ilow;
                node.left = build(plow + 1, plow + 1 + length, ilow, i);
                node.right = build(plow + 1 + length, phigh, i + 1, ihigh);
                break;
            }
        }
        
        return node;
    }
}
