class Solution {
    // [1] recursio  and memo
    public int change(int amount, int[] coins) {
        return dfs(coins, 0, amount, new HashMap<>());
    }

    int dfs(int[] coins, int i, int remAmount, Map<String, Integer> memo) {
        if (remAmount == 0) return 1; // 1 represents that there is one possible way to reach amount
 
        if (remAmount < 0) return 0; // 0 represents that there is no possible way

        // no coins left, amount unmet, so impossible
        if (i == coins.length)  return 0;

        String key = i + "," + remAmount;
        if (memo.containsKey(key)) return memo.get(key);

        // skip coin
        int skip = dfs(coins, i+1, remAmount, memo);

        // include coin
        int include = dfs(coins, i, remAmount - coins[i], memo);
        
        int result = skip + include;
        memo.put(key, result);
        return result;
    }
}
