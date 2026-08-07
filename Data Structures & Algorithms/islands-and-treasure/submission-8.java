// Shortest distance for graphs/matrix has to be BFS
class Solution {
    static final int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();

        // add all starting positions to start BFS from
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) queue.offer(new int[]{i,j});
            }
        }

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] d: directions) {
                int nRow = r + d[0];
                int nCol = c + d[1];


                // if neighbor is not already and is land(INF)
                if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && grid[nRow][nCol] == INF) {
                    grid[nRow][nCol] = grid[r][c]+1; // starts from 0 as treasure value is 0
                    queue.offer(new int[]{nRow, nCol});
                }
            } // all neighbors are visited at this point
        }
    }
}
