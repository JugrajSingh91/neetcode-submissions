class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int n: nums1) set.add(n);
        Set<Integer> list = new HashSet<>();
        for (int n: nums2) {
            if (set.contains(n)) list.add(n);
        }
        
        int[]  res = new int[list.size()];
        int index = 0;
        for (int n: list) {
            res[index] = n;
            index++;
        }
        return res;
    }
}