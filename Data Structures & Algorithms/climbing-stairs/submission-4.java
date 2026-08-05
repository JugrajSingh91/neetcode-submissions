class Solution {
    public int climbStairs(int n) {
        
        //return recurse(n, new HashMap<>());
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    int recurse(int n, Map<Integer, Integer> memo) {
        if (n <=1) return 1;

        if (memo.containsKey(n)) return memo.get(n);
        memo.put(n, recurse(n-1, memo) + recurse(n-2, memo));
        return memo.get(n);
    }
}
