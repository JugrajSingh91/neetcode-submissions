class Solution {
    public int climbStairs(int n) {
        
        return recurse(n, new HashMap<>());
    }

    int recurse(int n, Map<Integer, Integer> memo) {
        if (n <=1) return 1;

        if (memo.containsKey(n)) return memo.get(n);
        memo.put(n, recurse(n-1, memo) + recurse(n-2, memo));
        return memo.get(n);
    }
}
