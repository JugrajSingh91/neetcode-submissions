class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 0; // buy at l, sell at r;
        int max = 0;

        while(r < prices.length) {
            if (prices[l] < prices[r]) { // SP > CP 
                max = Math.max(max, prices[r] - prices[l]);
            } else {
                l = r;
            }
            r++;
        }
        return max;
    }
}
