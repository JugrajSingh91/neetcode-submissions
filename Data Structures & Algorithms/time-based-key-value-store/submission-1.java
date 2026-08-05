class TimeMap {
    static final String EMPTY_STRING = "";
    class TimeValue {
        String value;
        int timestamp;
        public TimeValue(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    Map<String, List<TimeValue>> store;

    public TimeMap() {
        store  = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<TimeValue> values = store.getOrDefault(key, new ArrayList<>());
        values.add(new TimeValue(value, timestamp));
        store.put(key, values);
    }
    
    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) return EMPTY_STRING;

        List<TimeValue> values = store.get(key);

        if (values.get(0).timestamp > timestamp) return EMPTY_STRING;

        int l = 0;
        int r = values.size()-1;
        while(l < r) {
            int mid = l + (r - l +1)/2; // since l will always end up being mid when i am left with just two elements, i need to move mid to right by 1
            int midTimeStamp = values.get(mid).timestamp;
            if (midTimeStamp == timestamp) return values.get(mid).value;
            if (midTimeStamp > timestamp) {
                r = mid - 1; // i can rule out mid when moving left
            } else {
                l = mid; // i cannot rule out mid when moving right since the mid could be the answer
            }
        }

        return values.get(l).value;
    }
}
