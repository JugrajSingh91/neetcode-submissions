class Solution {
    public int maxProfit(int[] prices) {
        return dfs(prices, 0, prices[0], "buy", new HashMap<>());
    }

    int dfs(int[] prices, int index, int costPrice, String buyOrSell, Map<String, Integer> memo) {
        if (index >= prices.length) return 0;
        String key = String.valueOf(index) + buyOrSell;

        if (memo.containsKey(key)) return memo.get(key);

        int res = Integer.MIN_VALUE;
         
        if (buyOrSell.equals("buy")) {
            // skip
            int skipBuy =  dfs(prices, index+1, costPrice, "buy", memo);
            // buy
            int buy = dfs(prices, index+1, prices[index], "sell", memo);
            //return Math.max(skipBuy, buy);
            res = Math.max(skipBuy, buy);
        } else { // sell
            // skip
            int skipSell = dfs(prices, index+1, costPrice, "sell", memo);
            // sell // and you can buy at the same price i.e., same index
            int sell = prices[index] - costPrice + dfs(prices, index, costPrice, "buy", memo);
            //return Math.max(skipSell, sell);
            res = Math.max(skipSell, sell);
        }
        memo.put(key, res);
        return res;
    }
}