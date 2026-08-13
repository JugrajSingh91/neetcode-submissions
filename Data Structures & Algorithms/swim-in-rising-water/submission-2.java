class Solution {
    // DFS with every value of t [minHeight, maxHeight] and see you can DFS to the bottom right corner
    // While we DFS we cannot go to a neighbor unless grid[r][c] <= t 
    // We can every value of t or we can binary search between [minHeight, maxHeight] 

    public int swimInWater(int[][] grid) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                min = Math.min(min, grid[r][c]);
                max = Math.max(max, grid[r][c]);
            }
        }

        //Binary search to find the value of t where we can DFS from grid[0][0] to grid[rows-1][cols-1] 
        int l = min;
        int r = max;
        int ans = max;
        while(l <= r) {
            int t = l + (r-l)/2;
            // the top left corner should be swimmable too so grid[0][0] <= t 
            if (grid[0][0] <= t && dfs(0,0,grid,directions,t, new HashSet<>())) { 
                // can reach right bottom corner, try smaller t value for a better result
                ans = Math.min(ans, t);
                r = t - 1;
            } else {
                // can't reach right bottom, try bigger value of t 
                l = t + 1;
            }

        }
        return ans;
    }

    boolean dfs(int r, int c, int[][] grid, int[][] directions, int t, Set<String> visited) {
        String key = r+","+c;
        visited.add(key);
        if (r == grid.length - 1 && c == grid[0].length - 1) return true;

        for (int[] d: directions) {
            int nRow = r + d[0];
            int nCol = c + d[1];
            String newkey = nRow+","+nCol;
            if (nRow >= 0 && nRow < grid.length && nCol >=0 && nCol < grid[0].length && !visited.contains(newkey) && grid[nRow][nCol] <= t) {
                if (dfs(nRow,nCol,grid,directions,t,visited)){
                    return true;
                }
            }
        }
        // if we have all directions we return false;
        return false;
    }
}
