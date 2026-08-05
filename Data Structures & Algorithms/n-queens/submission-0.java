class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        } 
        backtrack(0, board, result, n);
        return result;
    }

    void backtrack(int row, char[][] board, 
                            List<List<String>> result, int n) {
        if (row == n) {
            List<String> combo = new ArrayList<>();
            for (char[] ch: board) {
                combo.add(new String(ch));
            }
            result.add(new ArrayList<>(combo));
            return;
        }

        for (int c = 0; c < n; c++) {
            if (canPlace(row, c, board)) {
                board[row][c] = 'Q';
                backtrack(row+1, board, result, n);
                board[row][c] = '.';
            }
        }
        //combo.remove(combo.size() -1);
        return;
    }

    boolean canPlace(int r, int c, char[][] board) {
        for (int i = 0; i < r; i++) {
            if (board[i][c] == 'Q') return false;
        }

        int i = r-1, j = c-1;
        while (i >=0 && j >=0) {
            if (board[i][j] == 'Q') return false;
            i--;
            j--;
        }

        i = r-1; j = c+1;
        while(i >= 0 && j <= board.length - 1) {
            if (board[i][j] == 'Q') return false;
            i--;
            j++;
        }

        return true;
    }
}
