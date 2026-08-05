class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token: tokens) {
            if (Character.isDigit(token.charAt(0)) 
                || (token.charAt(0) == '-' && token.length() > 1)) {
                stack.push(Integer.parseInt(token));
                continue;
            } 
            int a = stack.pop();
            int b = stack.pop();
            if (token.equals("+")) {
                stack.push(a+b);
            } else if (token.equals("*")) {
                stack.push(a*b);
            } else if (token.equals("-")) {
                stack.push(b-a);
            } else if (token.equals("/")) {
                stack.push(b/a);
            }
        }
        return stack.pop();
    }
}
