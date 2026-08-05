class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), 0, target, result);
        return result;
    }

    void backtrack(int start, int[] nums, List<Integer> pathSoFar,
             int currSum, int target, List<List<Integer>> result) {
        
        if (currSum == target) {
            result.add(new ArrayList<>(pathSoFar));
            return;
        }

        if (currSum > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            currSum += nums[i];
            pathSoFar.add(nums[i]);
            backtrack(i, nums, pathSoFar, currSum, target, result);
            pathSoFar.remove(pathSoFar.size() - 1);
            currSum -= nums[i];
        }
    }
}
