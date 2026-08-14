class Solution {
    public int rob(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<>();
        
        //return dfs(nums, 0, memo); // start at index 0; for [1], [2] top down approaches
        //[3] bottom up DP
        int[] maxLoot = new int[nums.length];
        maxLoot[0] = nums[0]; // maxLoot at inidex 0 is one and only option
        if (nums.length == 1) return nums[0]; //edge case
        maxLoot[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int lootatI = maxLoot[i-2] + nums[i]; // including i
            int skipI = maxLoot[i-1];
            maxLoot[i] = Math.max(lootatI, skipI);
        }
        return maxLoot[nums.length-1];
    }

    //[1] Basic recusion which cause TLE
    //[2] Added memoization

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
