class Solution {
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int area = dfs(r, c, grid, directions);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    int dfs(int r, int c, int[][] grid, int[][] directions) {
        if (grid[r][c] == 0) {
            return 0;
        }

        // Sink the area so it is not counted again in area mapping
        grid[r][c] = 0;
        int area = 1;

        for (int[] d: directions) {
            int newR = d[0] + r;
            int newC = d[1] + c;
            if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length) {
                area = area + dfs(newR, newC, grid, directions);
            }
        }
        return area;
    }
}
