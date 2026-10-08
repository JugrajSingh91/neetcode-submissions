class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // we need a min heap to keep the jobs with the least capital required
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> {
            return Integer.compare(capital[a], capital[b]);
        });

        for (int i = 0 ; i < capital.length; i++) minHeap.offer(i);

        // we also need a maxheap which we will use to find the most profitable
        // job we can afford which we can afford

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> {
            return Integer.compare(profits[b], profits[a]);
        });

        while(k > 0) {

            //put all projects in maxHeap which can be started
            while(!minHeap.isEmpty() && capital[minHeap.peek()] <= w) {
                maxHeap.offer(minHeap.poll());
            }   

            if (maxHeap.isEmpty()) break; // no more projects can be started
            w += profits[maxHeap.poll()];
            k--;
        }
        return w;
    }
}