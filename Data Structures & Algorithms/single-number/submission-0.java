class Solution {
    public int singleNumber(int[] nums) {
        
        int num = nums[0];
        if (nums.length == 1) return num;
        for (int i = 1; i < nums.length; i++) num = num ^ nums[i];
        return num;
    }
}
