class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // use a heap which store value and index int[value][index]
        // if index is not valid i lazy delete data from heap

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> {
            return Integer.compare(b[0], a[0]);
        });

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            maxHeap.offer(new int[]{nums[i], i});
        }

        int[] candidate = maxHeap.peek();
        res.add(candidate[0]);

        for (int  i = k; i < nums.length; i++) {
            maxHeap.offer(new int[]{nums[i], i});

            while(!maxHeap.isEmpty() && maxHeap.peek()[1] <= i - k ) maxHeap.poll();

            int[] c = maxHeap.peek();
            res.add(c[0]);
        }

        int[] resArr = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}
