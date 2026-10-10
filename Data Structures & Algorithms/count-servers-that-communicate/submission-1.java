class Solution {
    public int countServers(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int res = 0;
        // process rows
        for (int r = 0; r < rows; r++) {
            int rCount = 0;
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) rCount++;
            }

            // if there are more than 2 servers in a row
            // add them to res and mark them
            // otherwise move on
            if (rCount < 2) continue;
            res += rCount;
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) grid[r][c] = -1;
            }
        }

        // process cols
        for (int c = 0; c < cols; c++) {
            int cCount = 0; int unmarked = 0;
            for (int r = 0; r < rows; r++) {
                if (Math.abs(grid[r][c]) == 1) {
                    cCount++;
                    if (grid[r][c] == 1) unmarked++;
                }
            }

            // if there are more than two servers in the column, 
            // count the unmarked ones towards the result
            if (cCount >= 2) res += unmarked; 
        }
        return res;
    }
}