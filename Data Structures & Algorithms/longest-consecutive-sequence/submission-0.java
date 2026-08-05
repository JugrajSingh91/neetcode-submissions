class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n: nums) set.add(n);

        int max = 0;
        int i = 0;
        while (i < nums.length) {
            int curr = nums[i];
            if (!set.contains(curr - 1)) {
                int count = 0;
                while(set.contains(curr)){
                    count++;
                    curr++;
                }
                max = Math.max(max, count);
            }
            i++;
        }
        return max;
    }
}
