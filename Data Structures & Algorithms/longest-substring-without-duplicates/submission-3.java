class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        Set<Character> set = new HashSet<>();

        int l = 0;
        int max = 1;

        for (int r = 0; r < s.length(); r++) {
            char currChar = s.charAt(r);
            
            while (set.contains(currChar) && l <= r) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(currChar);
            max = Math.max(max, r- l + 1);
        }
        return max;
    }
}
