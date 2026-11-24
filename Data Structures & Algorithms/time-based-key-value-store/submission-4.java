class TimeMap {
    Map<String, List<Pair>> store;
    public record Pair(String value, int timestamp){};

    public TimeMap() {
        store = new HashMap<>();
    }
    
    //can store multiple values for the same key at different time stamps 
    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) return "";

        // binary search for value with timestamp <= i/o timestamp
        List<Pair> list = store.get(key);
        int n = list.size();
        int l = 0;
        int r = n-1;
        String res = "";
        while(l <= r) {
            int mid = l + (r-l)/2;
            if (list.get(mid).timestamp == timestamp) return list.get(mid).value;

            if (list.get(mid).timestamp < timestamp) {
                res = list.get(mid).value; // potential answer
                l = mid+1; //look an answer with t closer to i/o timestamp 
            } else {
                r = mid - 1;
            }


        }
        return res;
    }
}
