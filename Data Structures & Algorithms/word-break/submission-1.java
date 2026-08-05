class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j,i); // string between j and i
                if (dp[j] && set.contains(sub)) {
                    dp[i] = true;
                    break; // move on with i we found a word
                }
            }
        }
        return dp[len];
    }
}
