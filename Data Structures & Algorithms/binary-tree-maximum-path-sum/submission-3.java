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
    int maxSum = Integer.MIN_VALUE;
    private int solve(TreeNode root){
        if(root == null) return 0;
        int leftSum = solve(root.left);
        leftSum = leftSum < 0 ? 0 : leftSum;
        int rightSum = solve(root.right);
        rightSum = rightSum < 0 ? 0 : rightSum;
        maxSum = Math.max(leftSum + rightSum + root.val, maxSum);
        return Math.max(leftSum, rightSum) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        maxSum = root.val; 
        solve(root);
        return maxSum;
    }
}
