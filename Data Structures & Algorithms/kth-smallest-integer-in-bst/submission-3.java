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
    List<Integer> inOrder = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return inOrder.get(k-1);
        
    }

    void dfs(TreeNode node, int k) {
        if (node == null) return;
        dfs(node.left, k);
        inOrder.add(node.val);
        dfs(node.right, k);
    }
}
