class Solution {
    // [1] Recursion plus memoizartion based on 0/1 Knapsack NeetCode lecture

    // this problem comes down to choosing a subset of stones whose cumulative weight is as close to 
    // totalSum/2.
    // No matter which sequence of choosing contending stones to smash, we will end up with a diff
    // the diff will be (stones we chose for subset A) - (stones we chose for subset B)
    // so if we choose subset A so that is is as close to  targetSum/2, then subsetA-subSetB will be the 
    // minimum. if subsetA is exactly 0, then the answer will be 0 as all stones in subset A will smash all stones of subset B
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        for (int stone: stones) totalSum += stone;
        int subSetASum = dfs(stones, 0, totalSum/2, new HashMap<>());
        int subSetBSum = totalSum - subSetASum;
        return Math.abs(subSetBSum - subSetASum);
    }

    int dfs(int[] stones, int i, int target, Map<String, Integer> memo) {
        if (i == stones.length) return 0;

        String key = i + "," + target;

        if (memo.containsKey(key)) return memo.get(key);

        // skip ith stone
        // tracking the total Sum of target by skipping the ith stone
        int skip = dfs(stones, i+1, target, memo); 

        // include ith stone
        // tracking the total Sum of target by including the ith stone
        int include = 0;
        // icluding the ith stone, and reducing the target
        // but making sure we dont exceed the target, so stopping right before
        if (target - stones[i] >= 0) {
            include = stones[i] + dfs(stones, i+1, target-stones[i], memo);
        }
        
        // int include will always be <=target so we pick the max amonf skip and include
        int result =  Math.max(skip, include);
        memo.put(key, result);
        return result;
    }
}