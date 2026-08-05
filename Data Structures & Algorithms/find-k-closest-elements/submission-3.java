class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // arr = [2,4,5,8], k = 2, x = 6
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> {
            if (Math.abs(a - x) == Math.abs(b - x)) {
                return Integer.compare(b,a);
            }   
            return Integer.compare(Math.abs(b - x), Math.abs(a - x));
        });

        // heap {4(diff = 2), 5(diff = 1)}
        for (int num: arr) {
            maxHeap.offer(num);
            
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>();

        while(maxHeap.size() > 0) {
            result.add(maxHeap.poll());
        }

        Collections.sort(result);
        return result;
    }
}