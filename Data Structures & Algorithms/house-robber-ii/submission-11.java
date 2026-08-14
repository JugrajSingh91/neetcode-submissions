class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==1) return nums[0];
        if (n==2) return Math.max(nums[0], nums[1]);
        
        //[3] bottom up DP

        //robFirst (houses 0 to n-2)
        int[] robFirst = new int[n];
        robFirst[0] = nums[0];
        robFirst[1] = Math.max(nums[0], nums[1]);

        
        for(int i = 2; i < n-1; i++) {
            int robI = robFirst[i-2] + nums[i];
            int skipI = robFirst[i-1];
            robFirst[i] = Math.max(robI, skipI);
        }

        //skipFirst (houses 1 to n-1)
        int[] skipFirst = new int[n];
        skipFirst[1] = nums[1];
        skipFirst[2] = Math.max(nums[1], nums[2]);

        for (int i = 3; i < n; i++){
            int robI = skipFirst[i-2] + nums[i];
            int skipI = skipFirst[i-1];
            skipFirst[i] = Math.max(robI, skipI);
        }

        return Math.max(robFirst[n-2], skipFirst[n-1]);
    }
}
