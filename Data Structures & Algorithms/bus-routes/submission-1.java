class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // Map:  busStops ->  [buses it serves]
        // Start at src, and BFS next level
        // Next level of BFS is all stops that all buses go to 
        // Mark buses and stops as seen

        // But what about the source? When we BFS start it, we put it in the queue
        // when do we mark buses and stops as visited?
        // if target is found, we return the level of BFS

        if (source == target) return 0;

        Map<Integer, List<Integer>> stopsToBusesMap = new HashMap<>();

        for (int b = 0; b < routes.length; b++) {
            for(int s = 0; s < routes[b].length; s++) {
                int busStop = routes[b][s];
                stopsToBusesMap.computeIfAbsent(busStop, k -> new ArrayList<>()).add(b);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> busesSeen = new HashSet<>();
        Set<Integer> stopsSeen = new HashSet<>();

        q.add(source);
        int busesTaken = 0;
        while (!q.isEmpty()) {
            int levelSize = q.size();

            // explore current level of BFS and add all stops that all buses that stop at current level can take you to next
            for (int i = 0; i < levelSize; i++) {
                int currentStop = q.poll();

                // if target reached then return BFS level count, i.e., buses taken
                if (currentStop == target) return busesTaken;

                // Mark stop as seen so that we dont visit it again
                stopsSeen.add(currentStop);

                // all buses that stop at currentStop
                List<Integer> buses = stopsToBusesMap.getOrDefault(currentStop, new ArrayList<>());

                for (int bus: buses) {
                    // if bus not taken yet, get all the stops it can take you to
                    if (!busesSeen.contains(bus)) {
                        // Mark bus as seen so that we dont visit it again
                        busesSeen.add(bus);
                        for (int stop: routes[bus]) {
                            // add stop to next level of BFS if stop not visited yet
                            if (!stopsSeen.contains(stop)) {
                                q.offer(stop);
                            }
                            
                        }
                    }
                }
            }
            busesTaken++;
        }
        return -1;
    }
}