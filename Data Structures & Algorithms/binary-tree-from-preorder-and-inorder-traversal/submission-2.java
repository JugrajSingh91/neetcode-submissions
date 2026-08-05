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
    Map<Integer, Integer> indices = new HashMap<>();
    int preIndex = 0; // this the index of root and tracks from left to right in preorder array
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indices.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length-1);
    }

    TreeNode dfs(int[] preorder, int l, int r) {
        if (l > r) return null;
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++; // as dfs runs from left to right, the preIndex moves exactly to 
        //build left tree before right tree
        int mid = indices.get(root.val); // find the root in index

        // these l, r index are not exact start and end of substree in preorder array
        // they rather help track the size of left and right trees ad calcutaed from inorder array
        root.left = dfs(preorder, l, mid-1); 
        root.right = dfs(preorder,mid+1, r);
        return root;
    }
}
