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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int sizeAtThisLevel = q.size();
            for (int i = 0; i < sizeAtThisLevel; i++) {
                TreeNode curr = q.poll();
                
                if (curr!=null) {
                    q.offer(curr.left);
                    q.offer(curr.right);
                  // if curr is null, all nodes after this should be null  
                } else {
                    // drain thw queue to make sure all node are null after this
                    while(!q.isEmpty()) {
                        if (q.poll() != null) return false;
                    }
                }
            }
        }
        return true;
    }
}