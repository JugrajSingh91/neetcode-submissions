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

        int subTreeSum = leftMax + rightMax + root.val;
        max = Math.max(subTreeSum, max);

        int maxChild = Math.max(leftMax, rightMax);

        int maxPath = (maxChild >= 0) ? root.val + maxChild : root.val;

        max = Math.max(max, maxPath);

        return maxPath; 

        // if i am returning i return left | right + curr
         // max subtree  = left + right +_ curr
    }
}
