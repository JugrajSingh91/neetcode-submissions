class TimeMap {
    Map<String, TreeMap<Integer, String>> store;

    public TimeMap() {
        store = new HashMap<>();
    }
    
    //can store multiple values for the same key at different time stamps 
    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) return "";

        TreeMap<Integer, String> treeMap = store.get(key);

        return treeMap.floorEntry(timestamp) == null ? "": treeMap.floorEntry(timestamp).getValue();
    }
}
