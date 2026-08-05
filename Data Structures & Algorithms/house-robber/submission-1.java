class Solution {
    public int rob(int[] nums) {
        return recurse(nums.length, nums, new HashMap<>());
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
