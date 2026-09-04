class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        int steps = 0;
        int i = 0, l = 0, r = 0;
        int maxReach = 0;

        while(r < nums.length-1) { // r reaching the last index means we stop, we made it!
            while(l <= r && l <= nums.length-1) {
                if (nums[l] + l >= maxReach) {
                    maxReach = nums[l] + l;
                }
                l++;
            }
            l = r+1;
            r = maxReach;
            steps++; 
        }
        return steps;
    }
}
