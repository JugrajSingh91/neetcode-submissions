class Solution {
    // Topological Sort (Kahn's algorithm)
    // starting from 0 indegree nodes, we do BFS, and remove layer after layer
    // each layer is a step into the longest increasing sequence
    // when all layers are processed, we get the answer
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int[][] indegree = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                String node = r + "," + c;
                for (int[] d : directions) {
                    int nRow = r + d[0];
                    int nCol = c + d[1];
                    if (nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols && matrix[nRow][nCol] > matrix[r][c]) {
                        indegree[nRow][nCol]++;
                    }
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (indegree[r][c] == 0) q.offer(new int[]{r,c});
            }
        }

        int res = 0;
        while(!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];
                for (int[] d: directions) {
                    int nRow = r + d[0];
                    int nCol = c + d[1];
                    if (nRow >=0 && nRow < rows && nCol >= 0 && nCol < cols && matrix[nRow][nCol] > matrix[r][c]) {
                        indegree[nRow][nCol]--;
                        if (indegree[nRow][nCol] == 0) q.offer(new int[]{nRow, nCol});
                    }
                }
            }
            res++;
        }
        return res;
    }
}



// Top Down memoization DP approach runs into Stack Overflow
/*
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int rows = matrix.length;
        int cols = matrix[0].length;
        int res = 1;
        int[][] memo = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int seq = dfs(r, c, matrix, directions, memo);
                res = Math.max(res, seq);
            }
        }
        return res;
    }

    int dfs(int r, int c, int[][] matrix, int[][] directions, int[][] memo) {
        
        if (memo[r][c] != 0) return memo[r][c];
        int max = 1;
        for (int[] d: directions) {
            int seq = 1;
            int nRow = r + d[0];
            int nCol = c + d[1];
            if (nRow >=0 && nRow < matrix.length && nCol >=0 && nCol < matrix[0].length && matrix[nRow][nCol] > matrix[r][c]) {
                seq += dfs(nRow, nCol, matrix, directions, memo);
            }
            max = Math.max(max, seq);
        }

        memo[r][c] = max;

        return max;
    }
}

*/
