class Solution {
    public int trap(int[] height) {
        // next tallest to right (default 0)
        // next tallest to left (default 0)
        // for each bar
        //   Sum += min of (leftTallest, rightTallest) - barHeight
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int max = height[0];
        for (int i = 0; i < n; i++) {
            
            if (height[i] > max) {
                max = height[i];
            }
            left[i] = max;
            
        }
        max= height[n-1];
        for (int i = n-1; i >= 0; i--) {
            
            if (height[i] > max) {
                max = height[i];
            }
            right[i] = max;
        }

        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            int h = Math.min(left[i], right[i]);
            ans += h - height[i];
        }
        return ans;
    }
}
