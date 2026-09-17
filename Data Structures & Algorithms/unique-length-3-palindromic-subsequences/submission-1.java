class Solution {
    public int countPalindromicSubsequence(String s) {
        int[][] boundary = new int[26][2];
        for (int[] arr : boundary) {
            Arrays.fill(arr, -1);
        }

        // Set 1st and last occurence of each chararter [a,z]
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (boundary[c-'a'][0] == -1) {
                boundary[c-'a'][0] = i;
                continue;
            }
            boundary[c-'a'][1] = i;
        }
        int res = 0;

        // for each char [a,z] find find unique chars between
        // 1st and last occurence
        for (char c = 'a'; c <= 'z'; c++) {
            int[] b = boundary[c-'a'];
            
            if (b[0] != -1 && b[1] != -1) {
                Set<Character> unique = new HashSet<>();
                for (int i = b[0]+1; i < b[1]; i++) {
                    if (unique.add(s.charAt(i))) res++;
                }
            }
        }
        return res;
    }
}

//Backtracking O(n^3) solution which hiit TLE
/*
class Solution {
    int count = 0; 
    Set<String>  unique = new HashSet<>();
    public int countPalindromicSubsequence(String s) {
        backtrack(s, "", 0);
        return count;
    }

    void backtrack(String s, String soFar, int index) {
        if (soFar.length() == 3) {
            StringBuilder sb = new StringBuilder(soFar);
            if (sb.reverse().toString().equals(soFar) && !unique.contains(soFar)) {
                count++;
                unique.add(soFar);
            }
            return;
        }

        for (int i = index; i < s.length(); i++) {   
            char c = s.charAt(i);
            backtrack(s, soFar + c, i + 1);
        }
    }

}

*/