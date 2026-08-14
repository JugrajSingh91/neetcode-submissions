class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==1) return nums[0];
        if (n==2) return Math.max(nums[0], nums[1]);
        
        //[4] bottom up DP optimal

        //robFirst (houses 0 to n-2)
        int r1 = nums[0];
        int r2 = Math.max(nums[0], nums[1]);
        int robFirst = 0;

        
        for(int i = 2; i < n-1; i++) {
            int robI = r1 + nums[i];
            int skipI = r2;
            robFirst = Math.max(robI, skipI);
            r1= r2;
            r2 = robFirst;
        }

        //skipFirst (houses 1 to n-1)
        int s1 = nums[1];
        int s2 = Math.max(nums[1], nums[2]);
        int skipFirst = 0;

        for (int i = 3; i < n; i++){
            int robI = s1 + nums[i];
            int skipI = s2;
            skipFirst = Math.max(robI, skipI);
            s1 = s2;
            s2 = skipFirst;
        }

        return Math.max(r2, s2);
    }
}
