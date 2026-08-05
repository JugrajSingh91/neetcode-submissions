class Solution {
    public int trap(int[] height) {
        //water retained at an index is the:
        // min(leftMax, rightMax) at the index - heightAtIndex

        // 1. Create a an array with leftMax for each index
        // 2. Create another array with rightMax for each index
        // interate the array and add the water retained at each index
        int n = height.length;
        int[] leftMax = new int[n];
        leftMax[0] = 0;
        int[] rightMax = new int[n];
        rightMax[n-1] = 0;
        int total = 0;

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
        }
        for (int i = n-2; i >=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i+1]); 
        }

        for (int i = 0; i < n; i++) {
            int waterTrapped = Math.min(leftMax[i], rightMax[i]) - height[i];
            total += (waterTrapped > 0)? waterTrapped : 0;
        }
        return total;
    }
}
