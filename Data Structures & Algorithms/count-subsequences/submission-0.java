class Solution {
    //[1] Recusion with memoization from LCS Neetcode lecture
    public int numDistinct(String s, String t) {
        return dfs(s,t,0,0,new HashMap<>());
    }

    int dfs(String s, String t, int i1, int i2, Map<String, Integer> memo) {
        // this base case should come first, because if both i1 and i2 reach their lenght together using the last chars to build the subsequence, we would want to return 1 instead of 0;
        if (i2 == t.length()) return 1; // one subsequence found;

        if (i1 == s.length()) return 0;

        String key  = i1+","+i2;
        if (memo.containsKey(key)) return memo.get(key);

        int ans = 0;

        if (s.charAt(i1) == t.charAt(i2)) {
            int include = dfs(s , t, i1+1, i2+1, memo);
            int skip  = dfs(s , t, i1+1, i2, memo); // Note only i1 -> not i2
            ans = include + skip;
        } else {
            // we can only move i1 since we have to include i2 every char in t
            int moveI1 = dfs(s, t, i1+1, i2, memo);
            //int moveI2 = dfs(s, t, i1, i2+1, memo);
            ans = moveI1 /*+ moveI2*/;
        }

        memo.put(key, ans);
        return ans;
    }
}
