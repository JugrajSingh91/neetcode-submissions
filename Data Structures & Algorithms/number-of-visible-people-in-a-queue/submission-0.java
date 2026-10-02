class Solution {
    // One pass monotonic decreasing stack
    public int[] canSeePersonsCount(int[] heights) {
        int[] res = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int curr = heights[i];
            // every element prior to the curr element to whom
            // curr element is their next taller item, we pop them and add 1 to their 
            // count of number of visible people as they definitely see the curr element
            while(!stack.isEmpty() && heights[stack.peek()] < curr) {
                res[stack.pop()]++;
            }

            // if the stack is not empty still, then the top of the stak element must be bigger 
            // than the current element and should be able to see it, so increase
            // their count by 1
            if (!stack.isEmpty()) res[stack.peek()]++;

            stack.push(i);
       }
       return res;
    }
}