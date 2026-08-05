class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        char[] s1Arr = new char[26];
        char[] s2Arr = new char[26];

        for (char c: s1.toCharArray()) {
            s1Arr[c - 'a']++;
        }

        int l = 0;
        int r = 0;

        while ( r < s1.length()){
            s2Arr[s2.charAt(r) - 'a']++;
            r++;
        }
        if (matches(s1Arr, s2Arr)) return true;

        while (r < s2.length()) {
            s2Arr[s2.charAt(r) - 'a']++;
            s2Arr[s2.charAt(l) - 'a']--;
            if (matches(s1Arr, s2Arr)) return true;
            l++;
            r++;
        }
        return false;
    }

    boolean matches(char[] s1Arr, char[] s2Arr) {
        for (int i = 0; i < 26; i++) {
            if (s1Arr[i] != s2Arr[i]) return false;
        }
        return true;
    }
}
