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
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return totalGoodNodes(root, root.val);
    }

    private int totalGoodNodes(TreeNode root, int currMax) {
        if (root == null) {
            return 0;
        }

        currMax = Math.max(root.val, currMax);

        if (root.left == null && root.right == null && root.val >= currMax) {
            return 1;
        }


        

        int left = totalGoodNodes(root.left, currMax);
        int right = totalGoodNodes(root.right, currMax);

        int total = left + right;

        if (root.val >= currMax) {
            return total + 1;
        } else {
            return total;
        }
    }
}
