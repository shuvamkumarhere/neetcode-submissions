/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private boolean check(TreeNode root, int leftB, int rightB){
        if(root == null) return true;
        if(!(root.val > leftB && root.val < rightB)){
            return false;
        }
        return check(root.left, leftB, root.val)
        && check(root.right, root.val, rightB);
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
