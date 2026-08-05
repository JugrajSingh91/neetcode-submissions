class Solution {
    public boolean validTree(int n, int[][] edges) {
        

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        Set<Integer> visited = new HashSet<>();

        // No disonnected nodes 
        // No cycles
        boolean hasCycle = dfsHelper(0, -1, visited, adjList);
        boolean disconnected = true;
        if (visited.size() == n) {
            disconnected = false;
        } 

        return !disconnected && !hasCycle;
    }

    /*
    * returns true if there is a cycle in the graph 
    */
    boolean dfsHelper(int node, int parent, Set<Integer> visited, Map<Integer, List<Integer>> adjList) {
        visited.add(node);
        for (int neighbor: adjList.get(node)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, node, visited, adjList);
            } else if (neighbor == parent) {
                continue; // skip
            } else { // neighbor has been visited before and is not a parent so there is a cycle
                return true;
            }
        }
        return false;
    }
}
