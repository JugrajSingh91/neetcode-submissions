class Solution {
    //Kadane's algorithm, but we need to maintain currMax, and currMin both, since multiplication of two negatives can make a positive number
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 1; i < nums.length; i++) { // starts from i = 1
            // if nums[i] is negative, currMin * nums[i] might be > than currMax * nums[i] if currmin is negativie and currMax is positive
            // three way comparison, the number itself, or multiple it with the max and min so far
            int saveCurrMax = currMax; // this is used to calculate both currMax and currMin
            currMax = Math.max(nums[i], Math.max(saveCurrMax * nums[i], currMin * nums[i]));
            //update currMin
            // three way comparison
            currMin = Math.min(nums[i], Math.min(saveCurrMax * nums[i], currMin * nums[i]));
        
            max = Math.max(max, currMax);
        }
        return max;
    }
}
