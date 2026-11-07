class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegrees = new int[numCourses];
        
        for (int[] p: prerequisites) {
            adjList.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
            indegrees[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) q.offer(i);
        }

        List<Integer> order = new ArrayList<>();

        while(!q.isEmpty()) {
            int h = q.poll();
            order.add(h);

            for (int n: adjList.getOrDefault(h, new ArrayList<>())) {
                indegrees[n]--;
                if (indegrees[n] == 0) q.offer(n);
            }
        }

        return (order.size() < numCourses) ? false: true; 
    }
}
