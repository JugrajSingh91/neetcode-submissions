class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        int[] suffixProduct = new int[nums.length];

        prefixProduct[0] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            prefixProduct[i+1] = nums[i] * prefixProduct[i];
        }

        suffixProduct[nums.length - 1] = 1;

        for (int i = nums.length -1; i > 0; i--) {
            suffixProduct[i-1] = nums[i] * suffixProduct[i];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = prefixProduct[i] * suffixProduct[i];
        }
        return res;
    }
}  
