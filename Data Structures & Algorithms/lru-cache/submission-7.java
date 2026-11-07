class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {
    
    Map<Integer, Node> map;
    Node left;
    Node right;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.capacity = capacity;
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    void insert(Node node) {
        Node prev = right.prev;
        // put the node node between prev and right
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node res = map.get(key);
        remove(res);
        insert(res);
        return res.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);

        if (map.size() > capacity) {
            Node lru = left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
