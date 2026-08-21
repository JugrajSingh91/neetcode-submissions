class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        return (s1.length() + s2.length() == s3.length() && dfs(s1, s2, s3, 0, 0, 0, new HashMap<>()));
    }

    boolean dfs(String s1, String s2, String s3, int i, int j, int k, Map<String, Boolean> memo) {
        if (s1.length() == i && s2.length() == j && s3.length() == k) return true;

        String key = i + "," + j + "," + k;
        if (memo.containsKey(key)) return memo.get(key);

        // if both s1[i] and s2[j] match s3[k], then one of the paths might reveal an interleaving, while the other may not. Take this for example:
        // s1 = "aa", s2 = "ab", s3 = "abaa"

        boolean matchs1 = false;
        boolean matchs2 = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            matchs1 = dfs(s1, s2, s3, i+1, j, k+1, memo);
        }
        
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)){
            matchs2 = dfs(s1, s2, s3, i, j+1, k+1, memo);
        }

        boolean ans =  matchs1 || matchs2;
        memo.put(key, ans);
        return ans;
    }
}

/*
s1 = "aa", s2 = "ab", s3 = "abaa"

if i greedily write something like 

if (s1[i] == s3[k]) return dfs(s1, s2, s3, i+1, j, k+1)
else if (s2[j] == s3[k]) return dfs(s1, s2, s3, i, j+1, k+1)
else return false;

Assuming that no matter if pick s1 or s2 when both match s3, i will get a genuine result, that's a misunderstanding

for s1 = "aa", s2 = "ab", s3 = "abaa" exmaple, 
s1[0] == s2[0] == s3[0]
but i pick s1, the next iteration will compare s1[1] "a", s2[0] "a" s3[1] "b" and none of s1 and s2 will match s3, 

if i had picked s2 first, the next iteration will compare s1[0] "a", s2[1] "b" s3[1] "b" and this would have worked.

So we might try both paths independently instead of using if/elseif
*/
