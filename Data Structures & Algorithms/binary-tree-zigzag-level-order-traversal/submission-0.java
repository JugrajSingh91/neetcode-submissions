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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        boolean leftToRight = true;

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> currLevel = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                

                if (leftToRight) {
                    currLevel.addLast(currNode.val);
                } else {
                    currLevel.addFirst(currNode.val);    
                }

                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);    
            } // current level traversal ends here
            leftToRight = !leftToRight; // switch direction
            result.add(new ArrayList<>(currLevel));
        }
        return result;
    }
}