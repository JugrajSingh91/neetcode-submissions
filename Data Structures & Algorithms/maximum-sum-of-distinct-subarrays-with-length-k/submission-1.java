class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int l = 0;
        long sum = 0;
        long res = 0;
        for (int r = 0; r < nums.length; r++) {
            int curr = nums[r];
            sum += curr;
            while((set.contains(curr) && l < r) || r-l+1 > k) {
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            }
            set.add(curr);
            if (r - l + 1 == k) res = Math.max(res, sum);
        }
        return res;
    }
}
