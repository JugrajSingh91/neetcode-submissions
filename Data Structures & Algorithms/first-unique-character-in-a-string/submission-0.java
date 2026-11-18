class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> charIndex = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charIndex.put(c, charIndex.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (charIndex.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}