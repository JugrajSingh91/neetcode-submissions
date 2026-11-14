class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int stick: sticks) minHeap.offer(stick);
        int ans = 0;
        while(minHeap.size() > 1) {
            int cost = minHeap.poll() + minHeap.poll();
            ans += cost;
            minHeap.offer(cost);
        }

        return ans;
    }
}
