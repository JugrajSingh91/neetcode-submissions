class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int ans = 0;
        int mid  = 0;
        while(l < r) {
            if (nums[l] < nums[r]) {
                return nums[l];
            }
            mid = l + (r - l)/2;
            
            //if left is unsorted, go left
            if (nums[l] > nums[mid]) { 
                r = mid;
            } else { // go right
                l = mid+1;
            } 
        }
        return nums[l];
    }
}
