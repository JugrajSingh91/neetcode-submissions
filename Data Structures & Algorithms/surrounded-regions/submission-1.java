class Solution {
    public void solve(char[][] board) {
        // if border node is 0, I ll dfs it to add to an ignore list
        // then i ll scan the grid again and dfs all nodes which are 0 and not 
        // in the ignore list and conver them to X
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') dfs(r, 0, directions, board, 'O', '1');
            if (board[r][cols-1] == 'O') dfs(r, cols-1, directions, board, 'O', '1');
        }
        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') dfs(0, c, directions, board, 'O', '1');
            if (board[rows-1][c] == 'O') dfs(rows-1, c, directions, board, 'O', '1');
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == '1') board[r][c] = 'O';
            }
        }
    }

    void dfs(int r, int c, int[][] directions, char[][] board, char oldChar, char newChar) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return;
        }

        if (board[r][c] != oldChar) {
            return;
        }

        board[r][c] = newChar;
        for (int[] d: directions) {
            dfs(r+d[0], c+d[1], directions, board, oldChar, newChar);
        }
        return;
    }
}
