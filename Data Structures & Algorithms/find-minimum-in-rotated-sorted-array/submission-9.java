class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int ans = 0;
        int mid  = 0;
        while(l < r) {

            mid = l + (r - l)/2;
            
            //if left is unsorted, go left
            if (nums[mid] > nums[r]) { 
                l = mid + 1;
            } else { // go right
                r = mid;
            } 
        }
        return nums[l];
    }
}
