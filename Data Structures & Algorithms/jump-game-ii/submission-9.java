class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        int steps = 0;
        int i = 0, l = 0, r = 0;
        int maxReach = 0;

        while(r < nums.length-1) { // r reaching the last index means we stop, we made it!
            
            // we scan the window l, r to find the index with the furthest reach
            while(l <= r && l <= nums.length-1) {

                // finding furthest reach within l,r window
                if (nums[l] + l >= maxReach) {
                    maxReach = nums[l] + l;
                }
                l++;
            }
            // once we have scanned the l, r window
            // we now need to scan from after r until the max reach. Note not starting
            // from the index which gave the maxreach, but starting from after r
            // since we scanned the complete l,r window already
            l = r+1;
            r = maxReach;
            steps++; 
        }
        return steps;
    }
}
