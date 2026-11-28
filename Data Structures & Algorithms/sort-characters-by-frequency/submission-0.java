class Solution {
    public String frequencySort(String s) {
        // decreasing order ofo freq
        Map<Character, Integer> freq = new HashMap<>();
        for (char c: s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> {
            if (freq.get(b) ==  freq.get(a)) return Character.compare(a,b);
            return Integer.compare(freq.get(b), freq.get(a));
        });
        for (char c: freq.keySet()) maxHeap.offer(c);
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            sb.repeat(c, freq.get(c));
        }
        return sb.toString();
    }
}