class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            // palindrom is odd length
            int l = i-1;
            int r = i+1;
            while(l >= 0 && r < n) {
                if (s.charAt(l) == s.charAt(r)) {
                    if (r - l + 1 > maxLen) {
                        ans = s.substring(l, r+1);
                        maxLen = r - l + 1;
                    }
                    l--;
                    r++;
                } else {
                    break;
                }
            }

            //palindrome is even length
            l = i; 
            r = i+1;
            while(l >= 0 && r < n) {
                if (s.charAt(l) == s.charAt(r)) {
                    if (r - l + 1 > maxLen) {
                        ans = s.substring(l, r+1);
                        maxLen = r - l + 1;
                    }
                    l--;
                    r++;
                } else {
                    break;
                }
            }
        }
        return (maxLen == 0 && n > 0)? s.substring(0,1) : ans; 
    }
}
