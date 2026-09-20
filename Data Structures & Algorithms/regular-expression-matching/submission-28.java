class Solution {
    public boolean isMatch(String s, String p) {
        return dfs(s, p, 0, 0, new HashMap<>());
    }

    boolean dfs(String s, String p, int i1, int i2, Map<String, Boolean> memo) {
        String key = i1 + "," + i2;

        if (memo.containsKey(key)) return memo.get(key);

        // if p ends so should s
        if (i2 == p.length()) return i1 == s.length();


        boolean matches = i1 < s.length() && (s.charAt(i1) == p.charAt(i2) || p.charAt(i2) == '.');

        boolean res = false;
        if (i2+1 < p.length() && p.charAt(i2+1) == '*') {
            boolean matchZero = dfs(s, p, i1, i2+2, memo);
            boolean matchOneOrMore = matches && dfs(s, p, i1+1, i2, memo);
            res = matchZero || matchOneOrMore;
        }   else {
            res = matches && dfs(s, p, i1+1, i2+1, memo);
        }

        memo.put(key, res);
        return res;
    }
}
