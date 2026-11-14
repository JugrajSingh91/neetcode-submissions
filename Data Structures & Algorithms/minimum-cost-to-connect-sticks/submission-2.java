class Solution {
    public int connectSticks(int[] sticks) {
        // Note: Just sorting the array is NOT the solution
        // example [5, 1, 5, 5]

        // If i sort it and start combing sticks from left to right [1, 5, 5, 5]
        // that will give me: 
        // [6, 5, 5] cost = 6
        // [11, 5] cost = 6+11
        // [16] cost = 6+11+16 = 33

        // Using a PriorityQueue will always make sure the shortest sticks are at the 
        // top of the heap for me to join
        // PQ<1, 5, 5, 5>
        // cost = 6 PQ<5, 5, 6>
        // cost = 6+10 PQ<6, 10>
        // cost = 6+10+16 PQ<16>
        // cost = 32 WINS!

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
