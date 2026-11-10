class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int l = 0;
        int res = 0; // length of max contiguous string whose agg cost <= maxCost

        int curr = 0;

        for (int r = 0; r < n; r++) {
            curr += cost[r];
            while(curr > maxCost) {
                curr -= cost[l];
                l++;
            }
            res = Math.max(res, r -l +1);
        }
        return res;
    }
}
