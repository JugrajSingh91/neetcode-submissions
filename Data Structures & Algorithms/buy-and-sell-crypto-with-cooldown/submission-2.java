class Solution {
    public int maxProfit(int[] prices) {
        return dfs(prices, 0, -1, true, new HashMap<>());
    }

    int dfs(int[] prices, int i, int purchaseIndex, boolean canBuy, Map<String, Integer> memo) {
        if (i >= prices.length) return 0;
        
        String key = i + "," + purchaseIndex + canBuy;
        if (memo.containsKey(key)) return memo.get(key);
        // can buy
        if (canBuy) {
            // buys
            int opt1 = dfs(prices, i+1, i,false, memo);
            // skips
            int opt2 = dfs(prices, i+1, -1, true, memo);
            int res = Math.max(opt1, opt2);
            memo.put(key, res);
            return res;
        } else { // can sell
            // sells i.e., make profit
            int profit = prices[i] - prices[purchaseIndex];
            int opt1 = profit +  dfs(prices, i+2, -1, true, memo); // cooldown period, can't purchase the next day so i+2

            // skips
            int opt2 = dfs(prices, i+1, purchaseIndex, false, memo);
            int res = Math.max(opt1, opt2);
            memo.put(key, res);
            return res;
        }
    }
}
