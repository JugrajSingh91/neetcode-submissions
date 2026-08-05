class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    void backtrack(int index, int[] nums, List<Integer> currList, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(currList));
            return;
        }
        int num = nums[index];
        currList.add(num);
        backtrack(index+1, nums, currList, result);
        currList.remove(currList.size() - 1);
        backtrack(index+1, nums, currList, result);
    }
}