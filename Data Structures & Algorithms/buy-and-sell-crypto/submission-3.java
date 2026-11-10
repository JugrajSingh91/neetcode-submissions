class Solution {
    public int maxProfit(int[] prices) {
        int buyAt = prices[0];
        int sellAt = prices[0];
        int max = 0;
        // [7,1,5,3,6,4]

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (price > sellAt) {
                sellAt = prices[i];
                max = Math.max(max, sellAt - buyAt);
            } else if (price < buyAt){
                buyAt = price;
                sellAt = price;
            }
        }
        return max;
    }
}
