class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // top edge
        // right column
        // bottom edge
        // left edge
        int left = 0;
        int right = matrix[0].length;
        int bottom = matrix.length;
        int top = 0;
        List<Integer> ans = new ArrayList<>();

        while (left < right && top < bottom) {
            // top edge
            for (int i = left; i < right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            // right column
            for (int i = top; i < bottom; i++) {
                ans.add(matrix[i][right-1]);
            }
            right--;
            if (!(left < right && top < bottom)) {
                break;
            }
            //bottom edge
            for (int i = right-1; i >= left; i--) {
                ans.add(matrix[bottom-1][i]);
            }
            bottom--;

            // left column
            for(int i = bottom-1; i >=top; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }
}
