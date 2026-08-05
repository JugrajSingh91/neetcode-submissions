class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length+1];

        for (int i = 1; i <= nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int i = 0; i < prefix.length; i++) {

            int need = prefix[i] - k;
            if (map.containsKey(need)) {
                res += map.get(need);
            }
            int a = map.getOrDefault(prefix[i], 0);
            map.put(prefix[i], a + 1);
        }

        return res;
    }
}