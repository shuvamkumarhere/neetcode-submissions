class Solution {
    private int idx = 0;

    private TreeNode solve(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) return null;
        
        TreeNode root = new TreeNode(preorder[idx++]);
        
        int i = start;
        while (inorder[i] != root.val) i++;
        
        root.left = solve(preorder, inorder, start, i - 1);
        root.right = solve(preorder, inorder, i + 1, end);
        
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder, inorder, 0, preorder.length - 1);
    }
}