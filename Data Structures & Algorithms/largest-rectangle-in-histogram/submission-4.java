class Solution {
    public int largestRectangleArea(int[] heights) {
        
        // 0, 1, 2, 3, 4, 5 (index)
        // 7, 1, 7, 2, 2, 4 (input)
        // 1,-1,3,-1,-1,-1  (end index)
        // -1,0,

        Stack<Integer> stack = new Stack();
        int[] rear = new int[heights.length];
        int[] front = new int[heights.length];
        Arrays.fill(rear, heights.length); 
        Arrays.fill(front, -1);
        
        stack.push(0);
        for(int i = 1; i < heights.length; i++) {
            while(!stack.empty() && heights[i] < heights[stack.peek()]) {
                rear[stack.pop()] = i;
            }
            stack.push(i);
        }

        Stack<Integer> nStack = new Stack();
        
        nStack.push(heights.length-1);
        for (int i = heights.length-2; i >=0; i--) {
            while(!nStack.empty() && heights[i] < heights[nStack.peek()]) {
                front[nStack.pop()] = i;
            }
            nStack.push(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int w = rear[i] - front[i] - 1;
            max = Math.max(max, w*heights[i]);
        }
        return max;
    }
}
