class Solution {
    // [1] Recursion with memoizaion based on LCS Neetcode lecture
    public int minDistance(String word1, String word2) {
        return dfs(word1, word2, 0, 0, new HashMap<>());
    }

    int dfs(String word1, String word2, int i1, int i2, Map<String, Integer> memo) {
        // subsequence matched, so the rest of the chars in word2 need to be deleted
        if( i2 == word2.length()) return word1.length() - i1; 

        // ran out of word1 so we need to add the rest of the chars remaining in word2 to word1
        if (i1 == word1.length()) return word2.length() - i2;  

        String key = i1 + "," + i2;
        if (memo.containsKey(key)) return memo.get(key);        
        int ed = 0;
        if (word1.charAt(i1) == word2.charAt(i2)) {
            return dfs(word1, word2, i1+1, i2+1, memo);
        } else{
            // insert into word1 so i2 moves
            int insert = 1 + dfs(word1, word2, i1, i2+1, memo);
            
            //delete into word1 so i1 moves
            int delete = 1 + dfs(word1, word2, i1+1, i2, memo);

            // replace so i1 and i2 move
            int replace = 1 + dfs(word1, word2, i1+1, i2+1, memo);
            ed = Math.min(Math.min(insert, delete), replace);
        }
        memo.put(key, ed);
        return ed;
    }
}
