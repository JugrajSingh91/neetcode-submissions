class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        for (int[] edge: prerequisites) {
            indegree[edge[0]] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();

        // if a node has indegree 0, enqueue it
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }   

        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);

            for (int[] edge: prerequisites) {
                if (edge[1] == node) {
                    indegree[edge[0]] -= 1;
                    if (indegree[edge[0]] == 0) {
                    queue.offer(edge[0]);
                }
                }
            }
        }

        return (order.size() == numCourses) ? order.stream().mapToInt(i -> i).toArray() : new int[0];
    }
}
