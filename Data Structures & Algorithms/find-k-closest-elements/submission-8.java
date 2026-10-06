class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // [diff, num]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            int diffWithA = a[0];
            int diffWithB = b[0];
            if (diffWithA != diffWithB) {
                return Integer.compare(diffWithB, diffWithA);
            }   
            return Integer.compare(b[1], a[1]);
        });


        for (int n: arr) {
            minHeap.offer(new int[]{Math.abs(n-x), n});
            if (minHeap.size() > k) minHeap.poll();
        }

        List<Integer> res = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            res.add(minHeap.poll()[1]);
        }
        Collections.sort(res);
        return res;
    }
}