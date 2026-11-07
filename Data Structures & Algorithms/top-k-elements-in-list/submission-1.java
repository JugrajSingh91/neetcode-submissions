class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqCounter = new HashMap<>();

        for (int n: nums) freqCounter.put(n, freqCounter.getOrDefault(n, 0) + 1);

        // [key, freq]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[1], b[1]);
        });

        for (int key: freqCounter.keySet()) {
            minHeap.offer(new int[]{key, freqCounter.get(key)});
            if (minHeap.size() > k) minHeap.poll();
        }

        int[] res = new int[k];
        int i = 0;
        while(minHeap.size() > 0) {
            res[i] = minHeap.poll()[0];
            i++;
        }
        return res;
    }
}
