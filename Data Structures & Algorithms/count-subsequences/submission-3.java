class Solution {
    public int numDistinct(String s, String t) {
        return dfs(s, t, 0, 0, new HashMap<>());
    }

    int dfs(String s, String t, int s1, int t1, Map<String, Integer> memo) {
        if (t1 >= t.length()) return 1;
        if (s1 >= s.length()) return 0;

        String key = s1 + "," + t1;
        if (memo.containsKey(key)) return memo.get(key);

        int res = 0;
        if (s.charAt(s1) == t.charAt(t1)) {
            // skip s1
            int skip = dfs(s, t, s1+1, t1, memo);
            // take it
            int take = dfs(s, t, s1+1, t1+1, memo);
            res = skip + take;
        } else {
            // keep looking
            res = dfs(s, t, s1+1, t1, memo);
        }

        memo.put(key, res);
        return res;
    }
}
