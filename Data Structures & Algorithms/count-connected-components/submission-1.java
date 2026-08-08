class Solution {
    public int countComponents(int n, int[][] edges) {
        // kruskal's algorithm
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i= 0 ; i < n; i++) adjList.put(i, new ArrayList<>());
        for (int[] edge: edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            List<Integer> node1Neighbors = adjList.get(node1);
            node1Neighbors.add(node2);
            adjList.put(node1, node1Neighbors);
            List<Integer> node2Neighbors = adjList.get(node2);
            node2Neighbors.add(node1);
            adjList.put(node2, node2Neighbors);
        }

        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int node: adjList.keySet()) {
            if (!visited.contains(node)){
                count++;
                dfs(node, adjList, visited);
            }
        }
        return count;

    }

    void dfs(int node, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor: adjList.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, adjList, visited);
            }
        }
    }
}
