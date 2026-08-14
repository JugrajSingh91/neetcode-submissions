class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        

        //[1] Simple recusion and [2] with memoization
        if (n ==1) return nums[0]; // edge case

        // if you rob the 1st house you can't rob the last
        // if you DONT rob the 1st house you can rob the last
        // they need separate maps for memoization
        int robFirst = dfs(nums, 0, n-2, new HashMap<>());
        int skipFirst = dfs(nums, 1, n-1, new HashMap<>());
        return Math.max(robFirst, skipFirst);
    }

    int dfs(int[] nums, int i, int last, Map<Integer, Integer> memo) {
        if (i > last) return 0;

        if (memo.containsKey(i)) return memo.get(i);

        int robI = nums[i] + dfs(nums, i+2, last, memo);
        int skipI = dfs(nums, i+1, last, memo);

        int result = Math.max(robI, skipI);
        memo.put(i, result);
        return result;
    }
}
