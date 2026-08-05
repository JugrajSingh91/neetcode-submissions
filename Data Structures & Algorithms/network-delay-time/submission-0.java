class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //Create adjacency list
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int[] time: times) {
            int u = time[0];
            int v = time[1];
            int t = time[2];
            List<int[]> existingNeighbor = adjList.getOrDefault(u,new ArrayList<>());
            existingNeighbor.add(new int[]{v,t});
            adjList.put(u, existingNeighbor);
        }

        // track min distances from k
        Map<Integer, Integer> distances = new HashMap<>();
        distances.put(k,0);

        // heap will contain {distance, node} pair in int[]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
            return Integer.compare(a[0], b[0]);
        });

        minHeap.offer(new int[]{0,k});

        while(!minHeap.isEmpty()) {
            int[] root = minHeap.poll();
            int distance = root[0];
            int node = root[1];

            // lazy deletion of stale nodes in heap
            if (distance > distances.getOrDefault(node, Integer.MAX_VALUE)) continue;

            // iterate through neighbors
            for (int[] edge: adjList.getOrDefault(node, new ArrayList<>())) {
                int neighbor = edge[0];
                int weight = edge[1];
                
                int proposedDistance = distance + weight;
                if (proposedDistance < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    distances.put(neighbor, proposedDistance);
                    minHeap.offer(new int[]{proposedDistance, neighbor});
                }
            }
        }
        if (distances.size() != n) return -1;

        int max = Integer.MIN_VALUE;
        for (int value: distances.values()) {
            max = Math.max(max, value);
        }
        return max;
    }
}
