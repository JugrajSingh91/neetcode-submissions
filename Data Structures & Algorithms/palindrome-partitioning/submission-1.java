class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, new ArrayList<>(), res);
        return res;
    }

    void backtrack(String remaining, List<String> pathSoFar, List<List<String>> res) {
        if (remaining.length() == 0) res.add(new ArrayList<>(pathSoFar));

        for (int i = 0; i < remaining.length(); i++) {
            String candidate = remaining.substring(0, i+1);
            if (isPalindrome(candidate)) {
                pathSoFar.add(candidate);
                backtrack(remaining.substring(i+1), pathSoFar, res);
                pathSoFar.remove(pathSoFar.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }
}
