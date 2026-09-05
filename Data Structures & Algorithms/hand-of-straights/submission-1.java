class Solution {
    // - Sort the elements
    // - Track frequencies
    // iterate over the hand array n times if n = number of groups formed
    // everytime start with the first element with freq > 0, and create a group
    // since groups are have consequtive elements, check if you can form a group of 2,3,4,5 for
    // example if the first element with freq you find is 2. and every element you use, reduce their freq.
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
            // look for the first element avialable to form a new group
            for (int i: hand) {
                if (freqCounter.containsKey(i)) {
                    // start making the group
                    int lastElement = i + groupSize - 1;

                    // check if you can form a group
                    while(i <= lastElement) {
                        // check if element is available. Will be true for the first element always but may not be true for the remaining we need to make the group
                        if (!freqCounter.containsKey(i)) return false;
                        
                        // reduce freq of used element
                        int count = freqCounter.get(i);
                        count--;
                        freqCounter.put(i, count);

                        // delete if freq = 0
                        if (count == 0) freqCounter.remove(i);

                        // next element needed in the group
                        i++;
                    }
                    break; // group has been made, break out of for loop
                }
            }
            n--; // one group has been made
        }
        return true;
    }
}
