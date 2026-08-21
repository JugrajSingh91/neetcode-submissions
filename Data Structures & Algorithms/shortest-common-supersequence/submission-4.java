class Solution {
    public String shortestCommonSupersequence(String str1, String str2) { // abac, cab
        int C = str1.length() + 1 ; // 4+1
        int R = str2.length()+ 1; // 3+1
        int[][] dp = new int[R][C]; //4*5
        
        dp[0][0] = 0;;
        // first column
        for (int r = 1; r < R; r++) { // cab loops from 1 2 3 
            dp[r][0] = r;
        }

        // first row
        for (int c = 1; c < C; c++) { // abac loops from 1 2 3 4 
            dp[0][c] = c;
        }

        for (int r = 1; r < R; r++) {
            for (int c = 1; c < C; c++) {
                if (str1.charAt(c-1) == str2.charAt(r-1)) {
                    dp[r][c] = dp[r-1][c-1] + 1;
                } else {
                    dp[r][c] = Math.min(dp[r-1][c], dp[r][c-1]) +1;
                }
            }
        }
        //trace back
        int r = R-1; // last row of dp (str2)
        int c = C-1; // last column of dp (str1)
        StringBuilder sb = new StringBuilder();
        // start tracing from bottom right corner
        while(r > 0 && c > 0) {
            // if chars are equal, move diagonally left up, thereby consuming chars from both strings
            if (str2.charAt(r-1) == str1.charAt(c-1)) { 
                sb.append(str2.charAt(r-1));
                r--;
                c--;
                continue;
            }
            // compare both the dp values above and to left, and move to the lower value, consuming the str accordingly. If moving up consuming the str matching the row, otherwise if moving left, consume the string matching the column
            if (dp[r][c-1] < dp[r-1][c]) { // move left
                sb.append(str1.charAt(c-1)); // consume str1
                c--;
            } else { // move above
                sb.append(str2.charAt(r-1)); // consume str2
                r--;
            }
        }

        // Append any leftover characters from str1 if str2 finished first
        while (c > 0) {
            sb.append(str1.charAt(c - 1));
            c--;
        }

        // Append any leftover characters from str2 if str1 finished first
        while (r > 0) {
            sb.append(str2.charAt(r - 1));
            r--;
        }
        return sb.reverse().toString();
    }


    // [1] Recursion and memo based on Neetcode LCS lecture
    /*String dfs(String str1, String str2, int i1, int i2, Map<String, String> memo) {
        if (str1.length() == i1) return str2.substring(i2, str2.length()); // if str1 exhausts,  we return the rest of str2

        if (str2.length() == i2) return str1.substring(i1, str1.length()); // vice versa

        String key = i1 + "," + i2;
        if (memo.containsKey(key)) return memo.get(key);

        String ans = "";

        // if both chars match, pick any and dfs with both indexes -> 
        if (str1.charAt(i1) == str2.charAt(i2)) {
            ans = str1.charAt(i1) + dfs(str1, str2, i1+1, i2+1, memo);
        } else {
            // if both chars are dfferent, choose each path
            String path1 = str1.charAt(i1) + dfs(str1, str2, i1+1, i2,  memo); // we take char at i1, i1++ , i2 stays 
            String path2 = str2.charAt(i2) + dfs(str1, str2, i1, i2+1, memo); // we take char at i2, i2++, i1 stays
            ans = (path1.length() < path2.length())? path1 : path2; // pick the shortest path
        }
        
        memo.put(key, ans);
        return ans;
    }*/


}