class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 1; i<=edges.length;i++) adjList.put(i, new ArrayList<>());

        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            // Build graph
            adjList.get(u).add(v);
            adjList.get(v).add(u);
            Set<Integer> visited = new HashSet<>();
            //check for cycle
            if (dfs(u, -1, visited, adjList)) {
                return edge;
            }
        }
        return new int[0];// bogus value;
    }

    // dfs such that we visit all neighbors except parent
    // this way if a node is already visited and and we see it again, that means there is a cycle
    boolean dfs(int node, int parent, Set<Integer> visited, Map<Integer, List<Integer>> adjList) {
        visited.add(node);
        for (int neighbor: adjList.get(node)) {
            if (neighbor == parent) continue; // ignore parent as that is not detecting a cycle
            if (!visited.contains(neighbor)) {
                dfs(neighbor, node, visited, adjList); // node is the parent of neighbor
            } else {
                return true; // cycle exists
            }
        }
        return false; // no cycle exists
    }
}
