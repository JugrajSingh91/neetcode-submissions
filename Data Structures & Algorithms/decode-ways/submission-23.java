class Solution {
    // [3] bottum up recursion
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        // num of ways to decode string of length index
        // so need an array with index n, hence array of size n+1;
        int[] decode = new int[s.length()+1]; 
        
        decode[0] = 1;
        decode[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            // Number of ways to decode string length i
            // == #ways to decode string of length i-1  and we include i-1 th char (if i-1 is not 0)
            // e.g., decode[2] = decode[1] + 2nd char in string i.e. i-1 (i == 2 here)
            // + # ways to deocode string of length i-2 and we inclulde (i-2,i) if it's >=10 and <=26
            int ways = 0;
            if (s.charAt(i-1) != '0') ways = decode[i-1];
            int candidate = Integer.parseInt(s.substring(i-2, i));

            if (candidate >= 10 && candidate <=26) {
                ways += decode[i-2];
            }
            decode[i] = ways;
        }
        return decode[s.length()];
    }  
}
