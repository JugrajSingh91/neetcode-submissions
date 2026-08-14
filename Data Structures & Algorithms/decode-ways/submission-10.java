class Solution {
    // [1] Simple recusion with memoization
    public int numDecodings(String s) {
        return  dfs(s, 0, new HashMap<>());

    }


    // Number of ways to decode the string starting at i
    int dfs(String s, int i, Map<Integer, Integer> memo) {
        if (i == s.length()) return 1; // end reached, string decoded so we found one way of doing it

        if (s.charAt(i) == '0') return 0; // illegal way to decode so no going down this route is not needed

        if (memo.containsKey(i)) return memo.get(i);
        int res = dfs(s, i+1, memo); // try the next character

        // let's also check if we can find another way to decode the string starting at i 
        // by trying to form a character for int [11,26] 

        if (i+1 < s.length()) {
            int check = Integer.parseInt(s.substring(i, i+2));
            if (check >= 10 && check <=26) res += dfs(s, i+2,memo); // Note i+2
        }
        memo.put(i, res);
        return res;
    }   
}
