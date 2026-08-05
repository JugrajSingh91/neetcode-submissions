class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int maxHops = k+1;
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight: flights) {
            graph.computeIfAbsent(flight[0], v -> new ArrayList<>())
            .add(new int[]{flight[1], flight[2]});
        }

        int[][] distances = new int[n][maxHops+1]; //each column for number of hops
        //fill array with Integer.MAX_VALUE
        for (int i = 0; i < distances.length; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }
        distances[src][0] = 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> {
            return Integer.compare(a[0], b[0]);
        });
        heap.offer(new int[]{0,src,0}); //cost,node,hops

        while(!heap.isEmpty()) {
            int[] root = heap.poll();
            int dist = root[0];
            int node = root[1];
            int currHops = root[2];

            if (dist > distances[node][currHops] || currHops == maxHops){
                continue;
            }

            for (int[] edge: graph.getOrDefault(node, Collections.emptyList())) {
                int neighbor = edge[0];
                int weight = edge[1];
                int newDist = dist + weight;

                if(newDist < distances[neighbor][currHops+1]) {
                    distances[neighbor][currHops+1] = newDist;
                    heap.offer(new int[]{newDist, neighbor, currHops+1});
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= k+1; i++){
            res = Math.min(distances[dst][i], res);
        }

        return (res == Integer.MAX_VALUE) ? -1 : res; 
    }
}
