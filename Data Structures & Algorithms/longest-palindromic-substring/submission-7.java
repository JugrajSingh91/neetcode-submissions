class Solution {
    //Two pointer approach
    public String longestPalindrome(String s) {
        int lIndex = 0;
        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i; // odd length
                
            while (l>=0 && r < s.length() && s.charAt(l)== s.charAt(r)) {
                if (r-l+1 > len) {
                    len = r-l+1;
                    lIndex = l;
                }
                l--;
                r++;
            }
            l = i;
            r = i+1; // even length
            while (l>=0 && r < s.length() && s.charAt(l)== s.charAt(r)) {
                if (r-l+1 > len) {
                    len = r-l+1;
                    lIndex = l;
                }
                l--;
                r++;
            }

        }
        return s.substring(lIndex, lIndex+len);
    }
}
