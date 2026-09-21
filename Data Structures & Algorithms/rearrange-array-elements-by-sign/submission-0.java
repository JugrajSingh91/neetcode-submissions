class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int n: nums) {
            if (n < 0) {
                neg.add(n);
            } else {
                pos.add(n);
            }
        }

        int[] res = new int[nums.length];
        int p = 0;
        int n = 0;
        for (int i = 0 ; i < nums.length; i++) {
            if (i % 2 == 0){
                res[i] = pos.get(p);
                p++;
            } else {
                res[i] = neg.get(n);
                n++;
            }
        }
        return res;
    }
}