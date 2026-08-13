class Solution {
    public int climbStairs(int n) {
        // Number of ways to reach step n = 
        // Number of ways to reach step n-1 + 
        // Number of ways to reach step n-2
        
        // [1] Simple recursion answer which will result in TLE
        //if (n == 1) return 1;
        //if (n == 2) return 2;
        //return climbStairs(n-1) + climbStairs(n-2);
        
        // [2] Add memoization
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1,1);
        memo.put(2,2);
        return memoization(memo, n);
    }

    int memoization(Map<Integer, Integer> memo, int n) {
        if (memo.containsKey(n)) return memo.get(n);
        int result = memoization(memo, n-1)+memoization(memo, n-2);
        memo.put(n, result);
        return memo.get(n);
    }
}
