/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/

public class ConvertSortedArray2BinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        int length = num.length;
        if(length == 0) {
            return null;
        }
        
        return getTree(num, 0, length - 1);
    }
    
    private TreeNode getTree(int[] num, int start, int ender) {
        if(start > ender) {
            return null;
        }
        
        int mid = (start + ender) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = getTree(num, start, mid - 1);
        node.right = getTree(num, mid + 1, ender);
        return node;
    }
}
