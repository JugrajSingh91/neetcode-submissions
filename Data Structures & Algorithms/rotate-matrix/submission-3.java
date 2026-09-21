class Solution {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // transpose
        for (int r = 0; r < rows; r++) {
            for (int c = r+1 ; c < cols; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;                
            }
        }
        // reverse rows

        for (int r = 0; r < rows; r++) {
            int start = 0;
            int end = cols-1;
            while(start < end) {
                int temp = matrix[r][start];
                matrix[r][start] = matrix[r][end];
                matrix[r][end] = temp;
                start++;
                end--;
            }
        }
    }
}
