class Solution {
    public int minDistance(String word1, String word2) {
        //mone
        //money
        return dfs(word1, word2, 0, 0, new HashMap<>());
    }

    int dfs(String word1, String word2, int w1, int w2, Map<String, Integer> memo) {
        if (w1 == word1.length()) {
            return word2.length() - w2;
        }

        
        if (w2 == word2.length()) {
            return word1.length() - w1;
        }

        String key = w1+","+w2;
        if (memo.containsKey(key)) return memo.get(key);

        int res = 0;
        //chars match move on
        if (word1.charAt(w1) == word2.charAt(w2)) {
            //return dfs(word1, word2, w1+1, w2+1);
            res = dfs(word1, word2, w1+1, w2+1, memo);
        } else {
            //chars dont match
            // replace
            int replace  = 1 + dfs(word1, word2, w1+1, + w2 +1, memo);
    
            // delete
            int delete = 1 + dfs(word1, word2, w1+1, w2, memo);
        
            // insert
            int insert = 1 + dfs(word1, word2, w1, w2+1, memo);

            //return Math.min(replace, Math.min(delete, insert));
            res = Math.min(replace, Math.min(delete, insert));
        }
        memo.put(key, res);
        return res;
    }
}
