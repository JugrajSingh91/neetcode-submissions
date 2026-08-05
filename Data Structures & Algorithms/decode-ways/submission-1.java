class Solution {
    public int numDecodings(String s) {
        if (s == null ||s.isEmpty() || s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length() + 1]; // index 0 -> n if length is n
        // so for 5 characters in the string the dp array is 0 to 5 i.e., 6 size

        dp[0] = 1; // if no charcaters are considered there is 1 way of doing this
        dp[1] = 1; // if one character is considered there is one way of doing this.

        for (int i = 2; i < dp.length; i++) {
            int singleDigit = Character.getNumericValue(s.charAt(i-1));
            int doubleDigit = Integer.parseInt(s.substring(i-2, i));

            boolean isValidSingle = (singleDigit >=1 && singleDigit <= 9) ;
            boolean isValidDoubleDigit = (doubleDigit >= 10 && doubleDigit <= 26);

            dp[i] = (isValidSingle? dp[i-1] : 0) + (isValidDoubleDigit? dp[i-2] : 0);
        }

        return dp[s.length()];
    }
}
