class Solution {
    public int[] countBits(int n) {
        // hellointerview solution is more intuitive
        // number of 1s in n = rightmost bit + number os 1s in n>>1
        int[] dp = new int[n+1];
        dp[0] = 0;
        //dp[1] = 1;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i>>1] + i%2;
        }

        return dp;
    }
}
