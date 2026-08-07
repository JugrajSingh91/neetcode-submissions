class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] directions  = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        Set<String> visited = new HashSet<>();
        int rows = board.length;
        int cols = board[0].length;

        // start from each cell in the board and try to find the word
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (backtrack(r, c, new StringBuilder(), word, directions, visited, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean backtrack(int r, int c, StringBuilder sb, String word, int[][] directions, Set<String> visited, char[][] board) {
        // consider the current char
        char curr = board[r][c];
        sb.append(curr);
        String key = r+","+c;
        visited.add(key);

        // if adding current char to the string we re building does not lead us to 
        // a result, then we dismiss it and return
        if (!sb.toString().equals(word.substring(0, sb.length()))) {
            sb.deleteCharAt(sb.length()-1);
            visited.remove(key);
            return false;
        }

        if (word.equals(sb.toString())) return true;

        for (int[] d: directions) {
            int newR = d[0] + r;
            int newC = d[1] + c;
            if (valid(newR, newC, board) && !visited.contains(newR+","+newC)) {
                if(backtrack(newR, newC, sb, word, directions, visited, board)) {
                    return true;
                }
            }

        }

        // if all directions have not failed extend the substring in line with the word we 
        // are searching, we dismiss this path and return
        sb.deleteCharAt(sb.length()-1);
        visited.remove(key);
        return false;

    }

    boolean valid(int r, int c, char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        if (r >= 0 && r < rows && c >= 0 && c < cols ) return true;
        return false;
    }
}
