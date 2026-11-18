class Solution {
    public boolean canJump(int[] nums) {
        // track max reach, and if i reach maxreach, it means i lose
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length-1) return true;
            if (i == maxReach) return false;
        }
        return true;
    }
}
