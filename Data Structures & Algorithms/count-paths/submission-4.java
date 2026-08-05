class Solution {
    public int uniquePaths(int m, int n) {
        //return recurse(m, n, new HashMap<>());
        int[][] dp = new int[m][n];

        // mark first row as 1 since there is only one way to reach any point in the
        // grid in row 1
        for (int c = 0; c < n; c++) {
            dp[0][c] = 1;
        }

        // mark first column as 1 since there is only one way to reach any point in the 
        // grid in column 1
        for (int r = 0; r < m; r++) {
            dp[r][0] = 1;
        }

        // start from second row and second column
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                dp[r][c] = dp[r-1][c] + dp[r][c-1];
            }
        }

        return dp[m-1][n-1];
    }

    int recurse(int m, int n, Map<String, Integer> memo) {
        if (m == 1 || n == 1) return 1;

        String key = m + "," + n;
        if (memo.containsKey(key)) return memo.get(key);
        int result = recurse(m-1, n ,memo) + recurse(m, n-1, memo);
        memo.put(key, result);
        return result;
    }
}
