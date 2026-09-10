class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        
        for (char c: s.toCharArray()) {
            int old = counter.getOrDefault(c, 0);
            old++;
            counter.put(c, old);
        }
        boolean hasSingle = false;
        int res = 0;
        for (int value: counter.values()) {
            if (value == 1 || value % 2 != 0) {
                hasSingle = true;
            }
            res += value/2;
        }

        return (hasSingle)? res*2+1 : res*2;
    }
}