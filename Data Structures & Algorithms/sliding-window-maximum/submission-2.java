class Solution {
    class Element {
        int value;
        int index;
        public Element(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Element> maxHeap = new PriorityQueue<Element>((a,b) -> {
            return Integer.compare(b.value, a.value);
        });

        //nums [1,2,1,0,4,2,6] // len = 7, k= 3
        int[] res = new int[nums.length - k + 1]; // len = 5
        int i = 0;
        for (; i < k; i++) maxHeap.offer(new Element(nums[i], i)); // 
        //PQ = [{2,5},{0,3}]
        res[0] = maxHeap.peek().value;
        for (; i < nums.length; i++) { // starting at i = 6 (k = 3)
            maxHeap.offer(new Element(nums[i], i));
            while(maxHeap.peek().index < i-k+1) { // i-k = 2
                maxHeap.poll();
            }
            res[i-k+1] = maxHeap.peek().value; // res[2, 1,4]
            
        }
        return res;
    }
}

