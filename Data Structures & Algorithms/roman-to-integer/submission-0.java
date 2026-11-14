class Solution {
    public int romanToInt(String s) {
        Map<Character, int[]> romanMap = new HashMap<>();
        romanMap.put('I', new int[]{1, 1}); // {value, rank}
        romanMap.put('V', new int[]{5, 2});
        romanMap.put('X', new int[]{10, 3});
        romanMap.put('L', new int[]{50, 4});
        romanMap.put('C', new int[]{100, 5});
        romanMap.put('D', new int[]{500, 6});
        romanMap.put('M', new int[]{1000, 7});
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) stack.push(c);

        int ans = 0;
        while(!stack.isEmpty()) {
            char fE = stack.pop();
            if (!stack.isEmpty()) {
                char sE = stack.peek();
                // if sE is smaller, we subtract sE from fE
                if (romanMap.get(sE)[1] < romanMap.get(fE)[1]) {
                    ans += romanMap.get(fE)[0] - romanMap.get(sE)[0];
                    stack.pop();
                    continue;
                }
            }
            ans += romanMap.get(fE)[0];
        }
        return ans;
    }
}