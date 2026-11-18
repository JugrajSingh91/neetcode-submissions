class Solution {
    public int minChanges(String s) {
        int count = 0;
        int l = 0;
        int r = 1;
        while(r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) count++;
            l = r+1;
            r = l+1;
        }     
        return count;   
    }
}
