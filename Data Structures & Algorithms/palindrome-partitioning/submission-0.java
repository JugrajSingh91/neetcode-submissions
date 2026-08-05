class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        backtrack(s, new ArrayList<>(), result);
        return result;
    }

    void backtrack(String remaining, List<String> pathSoFar, List<List<String>> result) {
        if (remaining.isEmpty()) {
            result.add(new ArrayList<>(pathSoFar));
            return;
        }

        for (int i = 1; i <= remaining.length(); i++) {
            String prefix = remaining.substring(0, i);
            if (isPalindrome(prefix)) {
                pathSoFar.add(prefix);
                backtrack(remaining.substring(i), pathSoFar, result);
                pathSoFar.remove(pathSoFar.size() - 1);
            }   
        }
    }

    boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
