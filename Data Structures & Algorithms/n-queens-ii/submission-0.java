class Solution {
    int total;
    public int totalNQueens(int n) {
        total = 0;
        char[][] board = new char[n][n];
        for (char[] row: board) Arrays.fill(row, '.');
        backtrack(0, board);
        return total;
    }

    void backtrack(int r, char[][] board) {
        if (r == board.length) {
            total++;
            return;
        }

        for (int c = 0; c < board.length; c++) {
            if (canPlace (r, c, board)) {
                board[r][c] = 'Q';
                backtrack(r+1, board);
                board[r][c] = '.';
            }
            
        }
        return;
    }

    boolean canPlace(int R, int C, char[][] board) {
        // check column above

        for (int r = 0; r < R; r++) {
            if (board[r][C] == 'Q') return false;
        }

        // check north west diagonal
        int r = R-1;
        int c = C-1;
        while(r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') return false;
            r--;
            c--;
        }

        // check north east diagonal
        r = R-1;
        c = C+1;
        while(r >= 0 && c < board.length) {
            if (board[r][c] == 'Q') return false;
            r--;
            c++;
        }
        return true;
    }
}