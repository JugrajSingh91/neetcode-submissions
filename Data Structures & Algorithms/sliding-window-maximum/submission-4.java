class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //[1 2 1 0 4 2 6 ] k= 3 res = 5
        // max heap, i need to store the index too
        // so i use the heap to track max element
        // and if top element is outpf window, i delete the elements until i find something withing range
        int n = nums.length;
        int[] res = new int[n-k+1];
        // [index, value] 
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {  
            return Integer.compare(b[1], a[1]);
        });

        // l = 0
        // r = l+k-1
        int r = 0;

        for (;r < k-1; r++) {
            maxHeap.offer(new int[]{r, nums[r]});
        }
        int resIndex = 0 ;
        for (; r < n; r++) {
            // add right edge of window to heap
            maxHeap.offer(new int[]{r, nums[r]});

            // prune heap of all elements outside window to the left edge
            while(maxHeap.peek()[0] < r- k +1) maxHeap.poll();

            res[resIndex] = maxHeap.peek()[1];
            resIndex++;
        }
        return res;
    }
}
