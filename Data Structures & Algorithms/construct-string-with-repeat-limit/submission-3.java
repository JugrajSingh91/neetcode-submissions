class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char c: s.toCharArray()) freq[c-'a']++;

        // [int, count]
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b[0], a[0]);
        });

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) maxHeap.offer(new int[]{i, freq[i]});
        }

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            // use all or repeatLimit
            int usage = Math.min(curr[1], repeatLimit);
            sb.repeat('a' + curr[0], usage);
            curr[1] -= usage;
            
            // if there is any count left, we need a gap char before we put
            // it back in the heap 
            if (curr[1] > 0) {
                // heap should have any char left for a gap
                if (maxHeap.isEmpty()) break;
                int[] gap = maxHeap.poll();
                // we only need to use one char from gap char
                sb.append((char)('a' + gap[0]));
                gap[1]--;
                // return the gapchar back to heap if there are any left
                if (gap[1] > 0) maxHeap.offer(gap);
                // put curr back to heap which will be max element again
                maxHeap.offer(curr);
            }
        }
        return sb.toString();
    }
}
