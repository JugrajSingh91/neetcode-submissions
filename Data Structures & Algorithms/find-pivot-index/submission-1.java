class Solution {
    public int pivotIndex(int[] nums) {
        int[] pSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            pSum[i+1] = pSum[i] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            // left
            int left = pSum[i];
            // right
            int right = pSum[nums.length] - pSum[i+1];
            if (left == right) return i;
        }
        return -1;
    }
}