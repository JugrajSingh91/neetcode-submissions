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

        int count = 0;
        if (root.val >= currMax) {
            count++;
            currMax = root.val;
        }

        int left = totalGoodNodes(root.left, currMax);
        int right = totalGoodNodes(root.right, currMax);

        return left + right + count;
    }
}
