class Solution {
    static final Map<Character, String> KEYBOARD = new HashMap<>(Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
        )); 
    public List<String> letterCombinations(String digits) {
         // digits 23 ("abc", "def")
        
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder currLetter, 
            List<String> result) {

        if (currLetter.length() == digits.length()) {
            result.add(currLetter.toString());
            return;
        }        

        String ch = KEYBOARD.get(digits.charAt(index)); // 2 : "abc"

        for (int i = 0; i < ch.length(); i++) {
            char c = ch.charAt(i); //a
            currLetter.append(c);
            backtrack(digits, index+1, currLetter, result);
            currLetter.deleteCharAt(currLetter.length() - 1);
        }
    }
}
