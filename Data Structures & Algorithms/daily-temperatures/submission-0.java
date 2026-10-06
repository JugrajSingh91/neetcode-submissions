class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int diff = i - stack.peek();
                res[stack.pop()] = diff;
            }
            stack.push(i);
        }
        return res;
    }
}
