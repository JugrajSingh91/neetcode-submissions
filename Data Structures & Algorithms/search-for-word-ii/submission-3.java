class Solution {
    Trie root;
    Set<String> allWords;

    private static class Trie {
        Map<Character, Trie> children;
        boolean eow;
        Trie() {
            children = new HashMap<>();
            eow = false;
        }
    }

    void addWord(String word) {
            Trie head = root;
            for (char c: word.toCharArray()) {
                if (!head.children.containsKey(c)) {
                    head.children.put(c, new Trie());
                }
                head = head.children.get(c);
            }
            head.eow = true;
        }

    
    public List<String> findWords(char[][] board, String[] words) {
        allWords = new HashSet<>();
        root = new Trie();
        for (String word: words) addWord(word);
        int rows = board.length;
        int cols = board[0].length;

        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Set<String> visited = new HashSet<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                backtrack(r,c,new StringBuilder(), root,board, directions, visited, allWords);
            }
        }
        return new ArrayList<>(allWords);
    }

    void backtrack(int r,int c, StringBuilder sb, Trie root, char[][] board, int[][] directions, Set<String> visited, Set<String> allWords) {

        

        char curr = board[r][c];
        String key = r+","+c;

        // if none of the children of root match the current element in board, return
        if (!root.children.containsKey(curr)) {
            return;
        }

        // xplore the child which matches the current board element
        root = root.children.get(curr);
        sb.append(curr);
        visited.add(key);

        // there could be more words down this branch so keep going instead of returning
        if (root.eow) allWords.add(sb.toString());

        //branch in all 4 directions, 
        for (int[] d: directions) {
            int newR = d[0] + r;
            int newC = d[1] + c;
            String newKey = newR+","+newC;
            if (newR >=0 && newR < board.length && newC >=0 && newC < board[0].length && !visited.contains(newKey)) {
                backtrack(newR, newC, sb, root, board, directions, visited, allWords);
            }
        }

        // we added the curr element to sb and visited
        // we tried to extend it in all four directions
        // Now we return to the previous recusion frame
        // but clean up before we do
        // remove it from sb and visited
        sb.deleteCharAt(sb.length() -1);
        visited.remove(key);
    }
}
