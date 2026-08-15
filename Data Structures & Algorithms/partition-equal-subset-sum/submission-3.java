class Solution {

    //[1] Recusion and memoization based on 0/1 Knapsack tutorial Neetcode
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int n : nums) total+=n;
        if (total%2 != 0) return false;
        int sum = total/2;
        return dfs(nums, 0, sum, new HashMap<>());
    }

    boolean dfs(int[] nums, int i, int sum, Map<String, Boolean> memo) {
        if (sum == 0) return true;
        if (i == nums.length) return false;

        String key = i + "," + sum;
        if (memo.containsKey(key)) return memo.get(key);

        // skip element at i
        boolean skip = dfs(nums, i+1, sum, memo);
        // include element at i
        boolean include = false;
        if (sum-nums[i] >= 0) {
            include = dfs(nums, i+1, sum-nums[i], memo);
        }

        memo.put(key,  skip || include);
        return skip || include;
    }
}
