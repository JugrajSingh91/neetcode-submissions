class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0) return res;

        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int top = 0;

        while (left <= right && top <= bottom) {
            // top row
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            // right column
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            // bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            

            // left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
