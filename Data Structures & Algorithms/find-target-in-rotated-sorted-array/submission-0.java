class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right  = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                return mid;
            }
            
            // is left sorted
            if (nums[left] <= nums[mid]  ) {
                // is target in left?
                if (nums[left] <= target && target < nums[mid]){
                    //go left
                    right = mid - 1;
                } else {
                    //go right
                    left = mid + 1;
                }
                    
            // right is sorted
            } else {
                //is target in right?
                if (target > nums[mid] && target <= nums[right]) {
                    //go right
                    left = mid + 1;
                } else {
                    //go left
                    right = mid - 1;
                }

            }
        }

        return -1;
    }
}

