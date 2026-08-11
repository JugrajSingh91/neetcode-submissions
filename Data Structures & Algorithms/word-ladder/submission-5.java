class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        // Prevent cycles by ensuring the graph cannot visit beginWord again
        wordSet.remove(beginWord); 

        int len = beginWord.length();
        // problem requests the sequence length (the number of words) rather than the number of steps (edges) taken:
        int dist = 1;
        while(!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) { // process all nodes at this level i BFS
                String currentWord = q.poll();
                if (currentWord.equals(endWord)) return dist; // word found at this level of BFS
                char[] currentWordArr = currentWord.toCharArray();
                // for each word at this level in BFS we try to find neighbors which
                // differ from the current word by one char and are present in the wordList
                for (int indexToReplace = 0; indexToReplace < currentWord.length(); indexToReplace++) {
                    char originalCharToReplace = currentWordArr[indexToReplace]; // char we want to replace and find neighbors in wordSet
                    for (char x = 'a'; x <= 'z'; x++) {
                        if (x == originalCharToReplace) continue;
                        currentWordArr[indexToReplace] = x;
                        String candidateNeighbor = new String(currentWordArr);
                        if (wordSet.contains(candidateNeighbor)) {
                            q.offer(candidateNeighbor);
                            // remove the neighbor wordlist to remove cycles from the bfs 
                            wordSet.remove(candidateNeighbor);
                        }
                    }
                    // restore origianl char after finding neighbor which differ by one char at indexToReplace
                    currentWordArr[indexToReplace] = originalCharToReplace;
                }

            } // all nodes at this level in BFS have been processed
            dist++;
            
        }
        return 0; // could not find the endword, starting at beginword
    }
}
