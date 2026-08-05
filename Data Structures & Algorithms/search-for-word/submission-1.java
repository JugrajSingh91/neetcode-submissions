class Solution {
    public boolean exist(char[][] board, String word) {

        if (board == null) return false;

        int[][] directions  = {{1,0},{-1,0},{0,1},{0,-1}};
        int rows = board.length, cols = board[0].length;
        
        Set<String> visited = new HashSet<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (backtrack(r, c, board, directions, new StringBuilder(), word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean backtrack(int r, int c, char[][] board, int[][] directions, 
            StringBuilder currWord, String word, Set<String> visited) {

        char ch = board[r][c]; 
        currWord.append(ch);
        String key = r + "," + c;
        visited.add(key);

        // if adding current char to the string we re building does not lead us to 
        // a result, then we dismiss it and return
        if (!word.substring(0,currWord.length()).equals(currWord.toString())) {
            currWord.deleteCharAt(currWord.length() - 1);
            visited.remove(key);
            return false;
        }

        if (word.equals(currWord.toString())) {
            return true;
        }

        // we welcome the new char and now let's explore its neightbors to keep building
        for (int[] d: directions) {
            int nRow = r + d[0];
            int nCol = c + d[1];
            String nkey = nRow + "," + nCol;
            if (nRow >= 0 && nRow < board.length && nCol >= 0 && nCol < board[0].length
                    && !visited.contains(nkey)) {
                if (backtrack(nRow, nCol, board, directions, currWord, word, visited)) {
                    return true;
                }
            }
        }
        currWord.deleteCharAt(currWord.length() - 1);
        visited.remove(key);
        return false;
    }
}
