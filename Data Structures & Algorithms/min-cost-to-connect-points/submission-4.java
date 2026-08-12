class Solution {
    // Prims' algo
    public int minCostConnectPoints(int[][] points) {
        // {weight, vertex} cost to add vertex to the MST
        // heap sorted by weight to add the vertex to tree
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> {
            return Integer.compare(a[0], b[0]);
        });
        
        // There are n vertices
        int n = points.length; // let's assume they are [0,n-1]
        
        Set<Integer> visited = new HashSet<>();

        // node -> List of neighbors like {weight, vertex}
        Map<Integer, List<int[]>> adjList = new HashMap<>();

        // Each node has n-2 neighbors potentially. It is a fully connected graph
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int[] u = points[i];
                int[] v = points[j];
                int weight = Math.abs(u[0]-v[0]) + Math.abs(u[1] - v[1]);
                adjList.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{weight, j});
                adjList.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{weight, i});

            }
        }

        int nodesProcessed = 0;

        // We put one node in heap
        heap.offer(new int[]{0,0}); // it takes 0 cost to add tge first node to the MST
        int cost = 0;

        while(!heap.isEmpty() && nodesProcessed < n) {
        // poll the heap
            int[] current = heap.poll();
            int node = current[1];
            int weight = current[0];

            // check if node is already visited
            if (visited.contains(node)) continue;
        
            // add node to visited list,
            visited.add(node);
            nodesProcessed++;

            // increment MST weight
            cost += weight;

            // check if all nodes are visisted
            if (nodesProcessed == n) return cost;

            // loop through neighbors and put them in heap if they haven't been visited
            for (int[] neighbor: adjList.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(neighbor[1])) {
                    heap.offer(new int[]{neighbor[0], neighbor[1]});
                }
            } 
        }
        return -1;
    }
}
