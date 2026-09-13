class WordDictionary {
    Trie root;

    static class Trie {
        Map<Character, Trie> children;
        boolean eow = false;
        Trie() {
            children = new HashMap<>();
            eow = false;
        }
    }

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie head = root;
        
        for (char c: word.toCharArray()) {
            if (head.children.containsKey(c)) {
                head = head.children.get(c);
                continue;
            }
            head.children.put(c, new Trie());
            head = head.children.get(c);
        }
        head.eow = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    boolean dfs(String word, Trie node, int index) {
        if (index == word.length()) return node.eow;

        char curr = word.charAt(index);

        if (node.children.containsKey(curr)) {

            return dfs(word, node.children.get(curr), index+1);
        } else if (curr == '.') {
            for (Trie t: node.children.values()) {
                if (dfs(word, t, index+1)) {
                    return true;
                }
                
            }
            return false;
        }

        // node children do not contains curr, and neither is curr '.'
        return false;
    }
}
