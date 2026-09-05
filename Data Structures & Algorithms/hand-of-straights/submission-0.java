class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        if (hand.length % groupSize != 0) return false;
        int n = hand.length/groupSize; // number of groups
        
        Map<Integer, Integer> freqCounter = new HashMap<>();
        for (int i: hand) {
            int count = freqCounter.getOrDefault(i, 0);
            count++;
            freqCounter.put(i, count);
        }

        while(n > 0) {
            for (int i: hand) {
                if (freqCounter.containsKey(i)) {
                    // start making the group
                    int lastElement = i + groupSize - 1;
                    while(i <= lastElement) {
                        if (!freqCounter.containsKey(i)) return false;
                        
                        int count = freqCounter.get(i);
                        count--;
                        freqCounter.put(i, count);

                        // delete if freq = 0
                        if (count == 0) freqCounter.remove(i);

                        i++;
                    }
                    break;
                }
            }
            n--;
        }
        return true;
    }
}
