class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] edge: prerequisites) {
            int a = edge[0];
            int b = edge[1];
            adjList.computeIfAbsent(b, k-> new ArrayList<>()).add(a);
            indegree[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (int neighbor: adjList.getOrDefault(node, new ArrayList<>())) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) q.offer(neighbor);
            }
        }
        if (ans.size() == numCourses) {
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = ans.get(i); 
            }
            return res;
        }
        return new int[0];
    }
}
