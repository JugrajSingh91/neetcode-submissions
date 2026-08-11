class Solution {
    // Hierholzer algorithm to find Eulerian path
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        
        for (List<String> ticket: tickets) {
            String u = ticket.get(0);
            String v = ticket.get(1);
            adj.computeIfAbsent(u, k -> new PriorityQueue<>()).offer(v);
        }

        List<String> res = new ArrayList<>();
        hierHolzerDFS("JFK", adj, res);
        return res;
    }

    void hierHolzerDFS(String source, Map<String, PriorityQueue<String>> adj, List<String> res) {
        PriorityQueue<String> neighbors = adj.get(source);

        while(neighbors != null && !neighbors.isEmpty()) {
            String neighbor = neighbors.poll();
            hierHolzerDFS(neighbor, adj, res);
        }
        res.add(0, source);
    }
}
