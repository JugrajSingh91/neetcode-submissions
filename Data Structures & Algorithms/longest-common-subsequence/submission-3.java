class Solution {
    //[1] Recursion with memoization based on Neetcode LCS lecture
    public int longestCommonSubsequence(String text1, String text2) {
        return dfs(text1, text2, 0, 0, new HashMap<>());
    }

    int dfs(String text1, String text2, int i1, int i2, Map<String, Integer> memo) {
        if (i1 == text1.length() || i2 == text2.length()) return 0;

        String key = i1 + "," + i2;
        if (memo.containsKey(key)) return memo.get(key);

        int ans = 0;
        if (text1.charAt(i1) == text2.charAt(i2)) {
            // chars match, let's add 1 for lenghth and move on to the subproblem
            ans = 1 + dfs(text1, text2, i1+1, i2+1, memo);
        } else {
            // chars dont match, so now we either increase i1 or i2 to find the next matching char
            ans = Math.max(dfs(text1, text2, i1+1, i2, memo), 
            dfs(text1, text2, i1,  i2+1, memo));
        }

        memo.put(key, ans);
        return ans;
    }
}
