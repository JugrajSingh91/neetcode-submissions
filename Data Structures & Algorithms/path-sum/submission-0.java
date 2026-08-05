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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, 0);
    }

    private boolean pathSum(TreeNode root, int targetSum, int currSum) {
        if (root == null) {
            return false;
        }

        currSum += root.val;

        if (root.left == null && root.right == null && currSum == targetSum) {
            return true;
        } 

        boolean left = pathSum(root.left, targetSum, currSum);
        boolean right = pathSum(root.right, targetSum, currSum);

        return left || right;

    }
}