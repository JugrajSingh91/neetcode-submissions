class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        for (int[] edge: prerequisites) {
            indegree[edge[0]] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        while(!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);

            // reduce indegree of all neighbors of node
            for (int[] edge: prerequisites) {
                if(edge[1] == node) {
                    indegree[edge[0]] -=1;

                    // if any node's indegree reduces to 0, add it to the queue
                    if (indegree[edge[0]] == 0) {
                        queue.offer(edge[0]);
                    }
                }
            }
        }

        return order.size() == numCourses ? true : false;
    }
}
