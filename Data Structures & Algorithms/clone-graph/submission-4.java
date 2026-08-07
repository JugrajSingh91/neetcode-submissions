/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> copy = new HashMap<>();
        dfs(node, new HashSet<>(), copy);
        return copy.get(node);
    }   

    void dfs(Node node, Set<Node> visited, Map<Node, Node> copy) {
        if (!copy.containsKey(node)) {
            copy.put(node, new Node(node.val));
        }
        Node clone = copy.get(node);

        visited.add(node);
        for (Node neighbor: node.neighbors) {
            if (!copy.containsKey(neighbor)) {
                copy.put(neighbor, new Node(neighbor.val));
            }
            clone.neighbors.add(copy.get(neighbor));

            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, copy);
            }
        }
    }
}