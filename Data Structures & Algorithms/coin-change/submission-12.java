class Solution {
    public int coinChange(int[] coins, int amount) {
        int rows = coins.length;
        int cols = amount + 1;

        // each rows records the min number of coins needed to meet the amount
        // if the amount can't be met, we record 0
        int[][] dp = new int[rows][cols];

        // when only one coin is available, we can fill out the first row
        for (int c = 0; c < cols; c++) {
            if (c == 0) {
                dp[0][c] = 0;
            }
            else if (c % coins[0] == 0) {
                dp[0][c] = c/coins[0];
            } else {
                dp[0][c] = Integer.MAX_VALUE/2;
            }
        }

        // first column will be 0, as 0 coins are needed to sum upto 0 amount
        for (int r = 0; r < rows; r++) {
            dp[r][0] = 0;
        }

        // iterate per row and fill out the array as we keep increasing the coins available to find the solution/. Row 1 and Col 1 are already processed
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                // option 1 skip the coin
                int skip = dp[r-1][c];

                // option 2 take the coin
                int include = Integer.MAX_VALUE/2;
                if (c - coins[r] >= 0) {
                    include = 1 + dp[r][c-coins[r]];
                }
                dp[r][c] = Math.min(skip, include);
            }
        }
        return (dp[rows-1][cols-1] >= Integer.MAX_VALUE/2)? -1 : dp[rows-1][cols-1];
    }
}
