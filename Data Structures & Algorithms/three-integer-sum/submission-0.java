class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            // Early exit: if nums[i] > 0, no triplet can sum to 0
            // since we sorted them
            if (nums[i] > 0) break;

            // skip to avoid duplicates
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            int target = -nums[i];
            while(j < k) {
                int whatWeHave = nums[j] + nums[k];
                if (whatWeHave == target) {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    // skip to avoid duplicates
                    while(j < k && nums[j] == nums[j-1]) j++;
                } else if (whatWeHave < target) {
                    j++;
                } else {
                    k--;
                }
                
            }
        }
        return res;
    }
}
