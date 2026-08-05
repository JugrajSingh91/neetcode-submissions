class PrefixTree {
    TrieNode root;

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean eow;

        public TrieNode() {
            this.children = new HashMap<>();
            this.eow = false;
        }

        void setEow(boolean eow) {
            this.eow = eow;
        }
    }

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode head = root;
        for (char c: word.toCharArray()) {
            if (!head.children.containsKey(c)) {
                head.children.put(c, new TrieNode());   
            }
            head = head.children.get(c);
        }
        head.setEow(true);
    }

    public boolean search(String word) {
        TrieNode head = root;
        for (char c: word.toCharArray()) {
            if (!head.children.containsKey(c)) {
                return false;
            }
            head = head.children.get(c);
        }
        return head.eow;
    }

    public boolean startsWith(String prefix) {
        TrieNode head = root;
        for (char c: prefix.toCharArray()) {
            if (!head.children.containsKey(c)) {
                return false;
            }
            head = head.children.get(c);
        }
        return true;
    }
}
