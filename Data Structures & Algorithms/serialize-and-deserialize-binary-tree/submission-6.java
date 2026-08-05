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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDFS(root, sb);
        return sb.toString();
    }

    // regular DFS and mark # for null values, note ","
    // preorder traveersal, so that we can use queue to pop and make root
    // when deserializing 
    void serializeDFS(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }

        sb.append(root.val).append(",");
        serializeDFS(root.left, sb);
        serializeDFS(root.right, sb);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));

        return deserializeDFS(nodes);
    }

    TreeNode deserializeDFS(Queue<String> nodes) {
        String node = nodes.poll();

        if (node.equals("#")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = deserializeDFS(nodes);
        root.right = deserializeDFS(nodes);
        return root;
    }
}
