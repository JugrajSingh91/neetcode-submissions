class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length+1];
         // Base cases: no cost to stand on the starting steps
        minCost[0] = 0; 
        minCost[1] = 0;

        for (int i = 2; i < minCost.length; i++) {
            minCost[i] = Math.min(cost[i-1] + minCost[i-1], cost[i-2]+ minCost[i-2]);
        }
        return minCost[cost.length];
    }
}
