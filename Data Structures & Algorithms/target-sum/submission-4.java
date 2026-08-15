class Solution {

    // [1] Recusion with top down memoization. Similar to 0/1 Knapsack neetcode lecture
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, new HashMap<>());
    }

    int dfs(int[] nums, int target, int i, Map<String, Integer> memo) {
        if (i == nums.length) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        String key = i+","+target;
        if (memo.containsKey(key)) return memo.get(key);

        // subtract
        int pathCount = dfs(nums, target - nums[i], i+1, memo);
        // add
        pathCount += dfs(nums, target + nums[i], i+1, memo);
        memo.put(key, pathCount);
        return pathCount;
    }
}
