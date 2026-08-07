class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // we sort to club the duplicates in the list together
        // so that we can easily skip them when needed
        Arrays.sort(nums);
        ans = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    void backtrack(int[] nums, int index, List<Integer> listSoFar, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(listSoFar));
        if (index == nums.length) {
             
            return;
        }
        
        for (int i = index; i < nums.length; i++) {
            // Logic is same as conbination sum 2
            // skip the duplicate if it's in the same recursion depth
            // When i == index, it is at a new recursion depth so we allow the duplicate.
            if (i > index && nums[i] == nums[i-1]) continue;
            int currElement = nums[i];
            listSoFar.add(currElement);
            backtrack(nums, i+1, listSoFar, ans);
            listSoFar.remove(listSoFar.size() - 1);
        }
    }
}
