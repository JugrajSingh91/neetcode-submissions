class Solution {
    public int largestRectangleArea(int[] heights) {
        // for each tower we need to find the next smaller tower
        // and we need this from both directions
        // this way if we maintain two stacks:
        //      1. leftBoundary
        //      2. rightBoundary
        //      Based on these we calculate the height of the rectangle area 
        //          as extended in both directions from each tower.

        // Find the rightMost boundary
        Stack<Integer> rStack = new Stack<>();
        int[] rightBoundary = new int[heights.length];

        Arrays.fill(rightBoundary, heights.length); // NOTE length
        for (int i = 0; i < heights.length; i++) {
            //if height at index is less than the height at stack top index
            //height at index is the rightMost boundary for stack top index 
            while (!rStack.empty() && heights[i] < heights[rStack.peek()]) {
                rightBoundary[rStack.pop()] = i;
            }   
            rStack.push(i);
        } 

        // Find the leftMost boundary
        Stack<Integer> lStack = new Stack<>();
        int[] leftBoundary = new int[heights.length];

        Arrays.fill(leftBoundary, -1); //NOTE -1
        for (int i = heights.length-1; i >= 0; i--) {
            //if height at index is less than the height at stack top index
            //height at index is the leftMost boundary for stack top index 
            while (!lStack.empty() && heights[i] < heights[lStack.peek()]) {
                leftBoundary[lStack.pop()] = i;
            }   
            lStack.push(i);
        } 
        
        //Find max area at each position
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = heights[i] * (rightBoundary[i]- leftBoundary[i]-1);
            ans = Math.max(ans, area);
        }

        return ans;
        //get max area 
    }
}
