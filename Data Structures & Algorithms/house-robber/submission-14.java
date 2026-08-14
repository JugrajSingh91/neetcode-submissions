class Solution {
    public int rob(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<>();

        //[3] bottom up DP optimal

        int a = nums[0];
        if (nums.length == 1) return a; 
        int b = Math.max(nums[0], nums[1]);
        if (nums.length == 2) return b;
        
        int maxLoot = 0;
        for (int i = 2; i < nums.length; i++) {

            int lootatI = a + nums[i]; // including i
            int skipI = b;
            maxLoot = Math.max(lootatI, skipI);
            a = b;
            b = maxLoot;
        }
        return maxLoot;
    }
}
