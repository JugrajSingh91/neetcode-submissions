class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        //dp[2] = Math.max(nums[0], nums[1]);

        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i-1], dp[i-1]);
        }
        return dp[nums.length];

        //return recurse(nums.length, nums, new HashMap<>());
    }

    int recurse(int count, int[] nums, Map<Integer, Integer> memo) {
        if (count == 1) return nums[0];
        if (count == 2) return Math.max(nums[0], nums[1]);

        if (memo.containsKey(count)) return memo.get(count);
        int include = recurse(count-2, nums, memo) + nums[count-1];
        int dontInclude = recurse(count-1, nums, memo);
        int result = Math.max(include, dontInclude);
        memo.put(count, result);
        return result;
    }
}
