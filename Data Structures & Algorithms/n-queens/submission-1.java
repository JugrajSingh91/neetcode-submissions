class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row: board) Arrays.fill(row, '.');
        List<List<String>> res = new ArrayList<>();
        dfs(0, board, res);
        return res;
    }

    void dfs(int r, char[][] board, List<List<String>> res) {
        if (r == board.length) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                String row = "";
                for (int j = 0; j < board[0].length; j++) {
                    row += board[i][j];
                }
                solution.add(row);
            }
            res.add(solution);
            return;
        };

        for (int c = 0; c < board[0].length; c++) {
            if (canPlace(r, c, board)) {
                board[r][c] = 'Q';
                dfs(r+1, board, res);
                board[r][c] = '.';
            }
        }
    }

    boolean canPlace(int r, int c, char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // column
        for (int i = 0; i < rows; i++) {
            if (board[i][c] == 'Q') return false;
        }


        // northeast
        int i = r-1;
        int j = c-1;
        while(i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i--;
            j--;
        }

        //northwest
        i = r-1;
        j = c+1;
        while(i >= 0 && j < board[0].length) {
            if (board[i][j] == 'Q') return false;
            i--;
            j++;
        }

        return true;
    }
}
