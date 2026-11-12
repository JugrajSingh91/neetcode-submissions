class Solution {
    public int subarraySum(int[] nums, int k) {

        // store the count of prefixSums
        Map<Integer, Integer> counter = new HashMap<>();
        counter.put(0, 1);
        
        int count = 0;
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            // i is curr index, i-1 is some prev index i need
            //prefixSum[i] - prefixSum[i-1] = k
            // prefixSum[i-1] = prefixSum[i] - k;
            int needed = runningSum - k;

            // if a prev prefixSum(s) exists, use that to update count
            count += counter.getOrDefault(needed, 0);

            counter.put(runningSum, counter.getOrDefault(runningSum, 0) + 1);
        }

        return count;
    }
}