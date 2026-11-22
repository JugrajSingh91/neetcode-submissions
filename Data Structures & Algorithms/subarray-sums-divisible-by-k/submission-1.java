class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // prefixSum
        // if remainder of two prefixSum divided by k, is the same
        // then the subarray between those two prefix sum is divisible by k
        // Example: i/p: [4, 5, 0] k = 5
        // prefixSum   : [4, 9, 9]
        // Remainders  : [4, 4, 4]
        // Subrray between first two i.e, [-, 5, -]
        // Subrray betwwen last two i.e, [-, -, 0]
        // subarray betwwen 1st and last i.e, [- 5, 0]
        // 3 subarrays hav sum divisible by 5  
        Map<Integer, Integer> remPos = new HashMap<>();
        remPos.put(0, 1);
        int runningSum = 0;
        int count = 0;
        
        for (int n: nums) {
            runningSum += n;
            int remainder = runningSum % k;
            
            // to keep remainder +ve
            // -6 % 5 (k) = -1
            //  make rem +ve by adding k i.e., -1+5 = 4
            // 9 % 5 = 4
            // so a hypothetical subarray where prefix sum is [-6, 9] should have a subarray
            // between them that is divisible by 5 such as an input array ; [-6, 15]!!  where
            // [-, 15] is the subarray divisible by 5
            if (remainder < 0) remainder += k;
            count += remPos.getOrDefault(remainder, 0);
            remPos.put(remainder, remPos.getOrDefault(remainder, 0)+1);
        }
        return count;
    }
}