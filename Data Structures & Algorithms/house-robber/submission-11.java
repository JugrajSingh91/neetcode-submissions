class Solution {
    public int rob(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<>();
        
        return dfs(nums, 0, memo); // start at index 0;
    }

    int dfs(int[] nums, int i, Map<Integer, Integer> memo ) {
        if (i >= nums.length) return 0;
        // either rob the house at index or dont
        // if you rob the house at index i, the next house you rob will be i+2
        if (memo.containsKey(i)) return memo.get(i);
        int robHouseAtI = nums[i] + dfs(nums, i+2, memo);
        // if you dont rob the house at index i, the next house you rob will be i+1
        int dontRobHouseAtI = dfs(nums, i+1, memo);

        int maxLootFromHousesTillI = Math.max(robHouseAtI, dontRobHouseAtI);
        memo.put(i, maxLootFromHousesTillI);
        
        return maxLootFromHousesTillI;
    }
}
