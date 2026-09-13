class Solution {
    static class Pair{
        int f;
        char c;
        Pair(int f, char c) {
            this.f = f;
            this.c = c;
        }
    }
    public String reorganizeString(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>((a,b) -> {
            return Integer.compare(b.f, a.f);
        });

        for (char c: s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (char c: freq.keySet()) {
            heap.offer(new Pair(freq.get(c), c));
        }

        StringBuilder sb = new StringBuilder();
        Pair prev = null;
        while(!heap.isEmpty()) {
            Pair head = heap.poll();

            sb.append(head.c);
            head.f--;

            // this part is interesting as it adds the prev but only when freq > 0
            if (prev != null && prev.f > 0) heap.offer(prev);

            prev = head;
        }

        // Line 33 makes sure heap empties out fast if we have a string like "aaab" and the stringbuilder length is shorter than the input string
        return (s.length() == sb.length())? sb.toString() : "";
    }
}