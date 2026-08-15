class Solution {

    //bottom up
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;

        for (int r = m-1; r >= 0; r--) {
            for (int c = n-1; c >= 0; c--) {
                //from right
                if (c+1 < n) dp[r][c] += dp[r][c+1];
                //from below
                if (r+1 < m) dp[r][c] += dp[r+1][c];
            }
        }
        return dp[0][0];
    }
}
