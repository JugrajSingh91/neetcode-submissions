class Solution {
    public int minCost(int[][] costs) {
        int minCost = Integer.MAX_VALUE;
        Map<String, Integer> memo = new HashMap<>();
        for (int c = 0; c < 3; c++) {
            minCost = Math.min(minCost,  dfs(0, c, costs, memo));
        }
        return minCost;
    }

    int dfs (int r, int c, int[][] costs, Map<String, Integer> memo) {
        String key = r+","+c;
        if (memo.containsKey(key)) return memo.get(key);

        // cost of painting house r, with color c
        int cost = costs[r][c];

        // if we reached the last house, return the cost, we dont need to paint more houses
        if (r == costs.length - 1) return cost;

        // otherwise now we pick the next house's color
        int totalCost = Integer.MAX_VALUE/2;
        for (int i = 0; i < 3; i++) {
            if (i == c) continue; // next house cannot be painted with the same color as current house
            totalCost = Math.min(totalCost, cost + dfs(r+1, i, costs, memo));
        }
        memo.put(key, totalCost);
        return totalCost;
    }
}