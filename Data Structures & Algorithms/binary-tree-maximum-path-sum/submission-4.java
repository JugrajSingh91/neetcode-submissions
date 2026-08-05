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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;

        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);

        // evaluate max subtree 
        int subTreeSum = leftMax + rightMax + root.val;
        max = Math.max(subTreeSum, max);


        // in case subtree is not the answer, we should return the maxPath
        // including root, and that would include only one child
        int maxChild = Math.max(leftMax, rightMax);

        // if both children are negative, we dont want to include them in the
        // path we send above, just the root val is better off
        int maxPath = (maxChild >= 0) ? root.val + maxChild : root.val;

        // in some cases a path is more valuable than a tree, so do this too
        max = Math.max(max, maxPath);

        return maxPath; 
    }
}
