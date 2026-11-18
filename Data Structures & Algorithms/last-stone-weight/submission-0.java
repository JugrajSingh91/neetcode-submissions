class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone: stones) maxHeap.offer(stone);

        while(maxHeap.size() > 1) {
            int firstStone = maxHeap.poll();
            int secondStone = maxHeap.poll();
            if (firstStone == secondStone) continue;
            maxHeap.offer(Math.abs(firstStone - secondStone));
        }

        return maxHeap.isEmpty()? 0 : maxHeap.poll();
    }
}
