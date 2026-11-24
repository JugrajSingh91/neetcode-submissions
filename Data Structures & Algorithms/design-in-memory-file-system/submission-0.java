class FileSystem {
    TrieNode fs;

    class TrieNode {
        Map<String, TrieNode> children;
        boolean file;
        String content;
        TrieNode() {
            this.children = new TreeMap<>();
            this.file = false;
            this.content = "";
        }
        
    }

    public FileSystem() {
        fs = new TrieNode();
    }
    
    public List<String> ls(String path) {
        TrieNode root = fs;
        String[] split = path.split("/");
        for (String s: split) {
            if (s.isBlank()) continue;
            root = root.children.get(s);
        }
        if (root.file) return List.of(split[split.length-1]);

        return new ArrayList<>(root.children.keySet());
    }
    
    public void mkdir(String path) {
        TrieNode root = fs;
        String[] split = path.split("/");
        for (String s: split) {
            if (s.isBlank()) continue;
            if (!root.children.containsKey(s)) {
                root.children.put(s, new TrieNode());  
            }
            root = root.children.get(s);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        TrieNode root = fs;
        String[] split = filePath.split("/");
        for (String s: split) {
            if (s.isBlank()) continue;
            if (!root.children.containsKey(s)) {
                root.children.put(s, new TrieNode());
            }
            root = root.children.get(s);
        }
        root.file = true;
        root.content += content;
    }
    
    public String readContentFromFile(String filePath) {
        TrieNode root = fs;
        String[] split = filePath.split("/");
        for (String s: split) {
            if (s.isBlank()) continue;
            root = root.children.get(s);
        }
        return root.content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
