class Solution {
    public boolean isValid(String s) {
        //([{}}])
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> combo = new HashMap<>();
        combo.put('}', '{');
        combo.put(']', '[');
        combo.put(')', '(');
        Set<Character> openingBracket = new HashSet<>();
        openingBracket.add('{');
        openingBracket.add('[');
        openingBracket.add('(');

        for(char c: s.toCharArray()) {
            if (openingBracket.contains(c)) {
                stack.push(c);
                continue;
            }
            //closing bracket
            if (stack.isEmpty()) return false;
            char topOfStack = stack.pop();
            if (!combo.containsKey(c) || combo.get(c) != topOfStack) return false;
        }
        return stack.isEmpty();
    }
}
