class Solution {
    public boolean canJump(int[] nums) {

        // Record the maxIndex we can currently jump to
        int maxReach = 0;

        // iterate from beginning to end, updating our maxReach
        for (int i = 0; i < nums.length; i++) {
            // if we have gone further than the max index we re allowed to jump to,
            // we re stuck
            if (i > maxReach) return false;
            
            // if jumping from current index can extend out reach
            // update the max Reach
            if (nums[i] + i > maxReach) maxReach = nums[i] + i;

            // if maxReach is already beyond the last index, we won!
            if (maxReach >= nums.length-1) return true;
        }
        return true;
    }
}
