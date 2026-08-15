class Solution {
    //[1] Recursion plus memoization. Like neetcode Knapsack 0/1 lecture
    public int findMaxForm(String[] strs, int m, int n) {
        return dfs(strs, m, n, 0, new HashMap<>());
    }

    int dfs(String[] strs, int m, int n, int i, Map<String, Integer> memo) {
        if (i == strs.length) {
            return 0;
        }

        String key = i + "," + m + "," + n;
        if (memo.containsKey(key)) return memo.get(key);

        String s = strs[i];
        int ones = 0;
        int zeroes = 0;

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '1') {
                ones++;
            } else {
                zeroes++;
            }
        }

        // skip string
        int skip = dfs(strs, m, n, i+1,  memo);
        // include string
        int include = 0;
        if (m-zeroes >= 0 && n-ones >= 0) {
            include = 1 + dfs(strs, m-zeroes, n-ones, i+1, memo);
        }
        
        memo.put(key, Math.max(skip, include));
        return Math.max(skip, include);
    }
}