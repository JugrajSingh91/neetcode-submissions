class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }

        int secondSlow = 0;
        while(slow != secondSlow) {
            slow = nums[slow];
            secondSlow = nums[secondSlow];
        }

        return slow;
    }
}
