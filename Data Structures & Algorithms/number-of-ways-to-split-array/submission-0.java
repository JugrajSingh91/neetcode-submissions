class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        
        for (int i = 1; i < n; i++) {
            prefixSum[i] = nums[i] + prefixSum[i-1];
        }

        int ans = 0;
        for (int i = 0; i < n-1; i++) {
            int prefix = prefixSum[i];
            int suffix = prefixSum[n-1] - prefix;
            if (prefix >= suffix) ans++;
        }
        return ans;
    }
}
