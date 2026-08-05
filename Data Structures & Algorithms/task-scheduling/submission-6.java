class Solution {
    // The central idea is to maintain a max heap
    // to poll task with the max frequency to run
    // And after running it, we put it in a cooldown queue
    // when the task is eligible to be run again, we put it back in the heap
    public int leastInterval(char[] tasks, int n) {
        // Create a dict.
        Map<Character, Integer> dict = new HashMap<>();
        for (char t: tasks) dict.compute(t, (k,v) -> 
            (v == null)? 1: v + 1);

        // create a max heap but only of frequencies, 
        // we dont care about the task names!
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        heap.addAll(dict.values());
        
        // Maintain a queue with {freq, timer} array so that
        // tasks can cool down, before thet are eligible to be 
        // run again
        Queue<int[]> q = new LinkedList<>();

        int cpuCycles = 0;

        // loop until both are empty, meaning that all tasks are processed
        while(!heap.isEmpty() || !q.isEmpty()) {
            cpuCycles++; 

            // if heap is not empty, POLL
            if (!heap.isEmpty()) { 
                int remainingCount = heap.poll() - 1; // count after running the task
                if (remainingCount > 0) {
                    q.offer(new int[]{remainingCount, cpuCycles+n});
                }
            }

            // if queue is not empty, see if tasks ahev cooled down?
            // check if the queue head has task which cooled down?
            if (!q.isEmpty() && q.peek()[1] == cpuCycles) {
                heap.offer(q.poll()[0]);
            }
        }
        return cpuCycles;
    }
}
