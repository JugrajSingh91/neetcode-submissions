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
    List<Integer> allNums;
    public int sumNumbers(TreeNode root) {
        allNums = new ArrayList<>();
        dfs(root, 0, allNums);
        int res = 0;
        for (int num: allNums) res += num;
        return res;
    }

    void dfs(TreeNode node, int numSoFar, List<Integer> allNums) {
        if (node == null) return;

        int valueNow = numSoFar*10 + node.val;
        if (node.left == null && node.right == null) {
            allNums.add(valueNow);
        }

        dfs(node.left, valueNow, allNums);
        dfs(node.right, valueNow, allNums);
    }
}