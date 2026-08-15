class Solution {
    //[recursion and memoization]
    public int uniquePaths(int m, int n) {
        int[][] directions = new int[][]{{1,0}, {0,1}};
        return dfs(0,0,m,n,directions, new HashMap<>());
    }

    int dfs(int r, int c, int rows, int cols, int[][] directions, Map<String, Integer> memo) {
        if (r == rows-1 && c == cols-1) return 1; // we have reached bottom right
        String key = r+","+c;
        if (memo.containsKey(key)) return memo.get(key);
        int paths = 0;
        for (int[] d : directions) {
            int nRow = d[0] + r;
            int nCol = d[1] + c;
            if (nRow < rows && nCol < cols) {
                paths += dfs(nRow, nCol, rows, cols, directions, memo);
            }
        }   
        memo.put(key, paths);

        return paths;
    }
}
