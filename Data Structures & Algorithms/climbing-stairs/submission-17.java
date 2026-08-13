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
        //Map<Integer, Integer> memo = new HashMap<>();
        //memo.put(1,1);
        //memo.put(2,2);
        //return memoization(memo, n);

        // [3] Bottom up DP conversion
        //int[] result = new int[n+1]; // since we need an index of n, so array size = n+1
        //if (n == 1) return 1;
        //result[1] = 1;
        //result[2] = 2;
        //for (int i = 3; i <= n; i++) {
        //    result[i] = result[i-1] + result[i-2];
        //}
        //return result[n];

        // [4] Further optimization by using 2 pointers only
        int a = 1;
        int b = 2;
        if (n == 1) return a;
        if (n == 2) return b;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = a+b;
            a = b;
            b = res;
        } 
        return res;
    }

    int memoization(Map<Integer, Integer> memo, int n) {
        if (memo.containsKey(n)) return memo.get(n);
        int result = memoization(memo, n-1)+memoization(memo, n-2);
        memo.put(n, result);
        return memo.get(n);
    }
}
