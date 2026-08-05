class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //[2,3,4,6,7,9] k = 3, x = 6
        //[4,3,2,0,1,3] 
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            if (r - l + 1 == k) {
                break;
            } 
            if (Math.abs(arr[l] - x) > Math.abs(arr[r] - x)) {
                l++;
            } else {
                r--;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i ++) {
            result.add(arr[l + i]);
        }
        return result;

        
        // arr = [2,4,5,8], k = 2, x = 6
        /*PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> {
            if (Math.abs(a - x) == Math.abs(b - x)) {
                return Integer.compare(b,a);
            }   
            return Integer.compare(Math.abs(b - x), Math.abs(a - x));
        });

        heap {4(diff = 2), 5(diff = 1)}
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
        return result;*/
    }
}