class Solution {
    // djistra gives us the min distance to reach the every node from k
    public int networkDelayTime(int[][] times, int n, int k) {
        // distances to reach a neighbor from k
        Map<Integer, Integer> distances = new HashMap<>();
        // adjList weighted u -> List of [v, weight] EDGES
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int i = 1; i <=n; i++) {
            adjList.put(i, new ArrayList<>());
            distances.put(i, Integer.MAX_VALUE);
        }
        distances.put(k,0);
        for (int[] time: times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adjList.get(u).add(new int[]{v, w});
        }

        // min heap [distance, node]
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        heap.offer(new int[]{0,k});

        while(!heap.isEmpty()) {
            int[] node = heap.poll();
            int v = node[1];
            int d = node[0]; // as noted in heap
            
            // lazy deletion
            if (d > distances.get(v)) continue;
            
            // explore neighbors of v
            for (int[] neighbor: adjList.get(v)) {
                int v1 = neighbor[0];
                int w = neighbor[1];
                int proposedDistance  = d + w;
                if (distances.get(v1) > proposedDistance) {
                    distances.put(v1, proposedDistance);
                    heap.offer(new int[]{proposedDistance, v1});
                }
            }

        }
        int max = Integer.MIN_VALUE;
        for (int value: distances.values()) {
            if (value == Integer.MAX_VALUE) return -1;
            max = Math.max(max, value);
        }
        return max;      
    }
}
