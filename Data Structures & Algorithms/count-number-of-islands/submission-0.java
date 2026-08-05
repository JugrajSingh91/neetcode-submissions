class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    dfsHelper(r, c, grid, directions);
                }
            }
        }
        return count;
    }

    void dfsHelper(int r, int c, char[][] grid, int[][] directions) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return;
        }

        if (grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        for (int[] direction: directions) {
            dfsHelper(r + direction[0], c + direction[1], grid, directions);
        }

        return;
    }


}
