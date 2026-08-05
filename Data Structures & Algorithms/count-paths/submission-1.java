class Solution {
    public int uniquePaths(int m, int n) {
        return recurse(m, n, new HashMap<>());
    }

    int recurse(int m, int n, Map<String, Integer> memo) {
        if (m == 1 || n == 1) return 1;

        String key = m + "," + n;
        if (memo.containsKey(key)) return memo.get(key);
        int result = recurse(m-1, n ,memo) + recurse(m, n-1, memo);
        memo.put(key, result);
        return result;
    }
}
