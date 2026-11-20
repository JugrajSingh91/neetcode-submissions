class Solution {
    // two heaps, one for pending tasks sorted by startTime
    // second heap of avaialble tasks sorted by processingTime
    // Maintain currTime
    // Move tasks from pendingtask heap to availabletask heap based on currTime
    // and increment curr Time as you process tasks in availabletask heap
    public int[] getOrder(int[][] tasks) {
        //[startTime, taskTime,  index]
        PriorityQueue<int[]> pendingHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        for (int i =0; i < tasks.length; i++) {
            pendingHeap.offer(new int[]{tasks[i][0], tasks[i][1], i});
        }

        PriorityQueue<int[]> aHeap = new PriorityQueue<>((a, b) -> {
            // if both tasks have same processing time, choose the one with shorter index
            if (a[1] == b[1]) return Integer.compare(a[2], b[2]);
            return Integer.compare(a[1], b[1]);
        });

        int[] firstTask = pendingHeap.poll();
        int currTime = firstTask[0];
        aHeap.offer(new int[]{firstTask[0], firstTask[1], firstTask[2]});
        List<Integer> res = new ArrayList<>();
        while(!aHeap.isEmpty()) {
            int[] currTask = aHeap.poll();
            res.add(currTask[2]);

            //update curr time
            currTime += currTask[1];

            while(!pendingHeap.isEmpty() && currTime >= pendingHeap.peek()[0]) {
                int[] taskAvailable = pendingHeap.poll();
                aHeap.offer(new int[]{taskAvailable[0], taskAvailable[1], taskAvailable[2]});
            }

            // if no task is avaialble, update curr time to the latest task in pending task heap
            if (aHeap.isEmpty() && !pendingHeap.isEmpty()) {
                int[] taskAvailable = pendingHeap.poll();
                currTime = taskAvailable[0];
                aHeap.offer(new int[]{taskAvailable[0], taskAvailable[1], taskAvailable[2]});
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }
}