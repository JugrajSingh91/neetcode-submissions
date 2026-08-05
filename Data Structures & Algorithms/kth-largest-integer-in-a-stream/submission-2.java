class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k_;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        k_ = k;
        for (int num: nums) {
            minHeap.offer(num);
            if (minHeap.size() > k_) minHeap.poll();
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k_) minHeap.poll();
        return minHeap.peek();
    }
}
