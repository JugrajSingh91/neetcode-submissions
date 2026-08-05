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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (sameTree(root, subRoot)) return true;

        boolean left = false;
        boolean right = false;

        if (root.left != null) return left = isSubtree(root.left, subRoot);

        if (root.right != null) return right = isSubtree(root.right, subRoot);

         return left || right;
    }

    boolean sameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;

        if (root1 == null || root2 == null) return false;

        if (root1.val != root2.val) return false;

        return (root1.val == root2.val) 
            && sameTree(root1.left, root2.left) 
                && sameTree(root1.right, root2.right);
    }
}
