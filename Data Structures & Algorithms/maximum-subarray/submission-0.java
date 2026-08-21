class Solution {
    // kadane's algorithm
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // if the trailing sum is negative, adding it to curr num will not help,
            // so we compare the result if include the curr num with trialing sum vs just the curr num itself
            currSum = Math.max(nums[i], currSum+nums[i]);
            max = Math.max(max,  currSum);
        }
        return max;
    }
}
