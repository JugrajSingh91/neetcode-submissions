class Solution {
    // DFS 2
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 1; i<=edges.length;i++) adjList.put(i, new ArrayList<>());

        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            // check if adding this edge to the graph
            // can u and v meet without adding the edge [u,v] yet
            if (hasPath(u, v, new HashSet<>(), adjList)) {
                // u,v already has a path so adding edge [u,v] will create a cyle
                return edge;
            }
            // otherwise add it to build graph
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return new int[0];// bogus value;
    }

    // dfs such we try to reach target via all neighbors of source
    // Note that the edge [u,v] hasn't been added to the graph yet so 
    // ideally there shouldn'y be a path from u -> v, if there is already a path, 
    // then adding [u,v] will create a cycle 
    boolean hasPath(int source, int target, Set<Integer> visited, Map<Integer, List<Integer>> adjList) {
        if (source == target) return true;
        visited.add(source);
        for (int neighbor: adjList.get(source)) {
            if (!visited.contains(neighbor)) {
                if(hasPath(neighbor, target, visited, adjList)) { // target remains the same
                    return true;
                }  
            }
        }
        return false; // no path exists
    }
}
