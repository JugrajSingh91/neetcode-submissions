class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int l = 0, r = 0;
        int zeroCount = 0;

        for (; r < nums.length; r++) {
            if (nums[r] == 0) zeroCount++;

            while(zeroCount > k) {
                if (nums[l] == 0) {  
                    zeroCount--;
                }
                l++;
            }

            max = Math.max(r-l+1, max);
        }
        return max;
    }
}