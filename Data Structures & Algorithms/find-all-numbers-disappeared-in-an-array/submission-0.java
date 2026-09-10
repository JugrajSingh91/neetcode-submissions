class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] present = new boolean[nums.length + 1];
        for (int i: nums) present[i] = true;

        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < present.length; i++) {
            if (present[i] == false) res.add(i);
        }
        return res;
    }
}