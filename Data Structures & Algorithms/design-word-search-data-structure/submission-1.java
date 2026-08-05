class WordDictionary {
    TrieNode root;
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean eow;
        public TrieNode() {
            this.children = new HashMap<>();
            this.eow = false;
        }
    }

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c: word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.eow = true;
    }

    public boolean search(String word) {
        return recurse(root, word, 0);
    }

    public boolean recurse(TrieNode curr, String word, int index) {

        if (index == word.length()) {
            return curr.eow;
        }
        // word is .ay
        char c = word.charAt(index); // a -> y
        if (curr.children.containsKey(c)) {
            curr = curr.children.get(c);
            return recurse(curr, word, index + 1);
        } else if (c == '.') {
            for (TrieNode child: curr.children.values()) {
                if (recurse(child, word, index + 1)) {
                    return true;
                }
            } 
            return false;
        } 
        return false;
    }
}
