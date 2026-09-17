class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRow = false;
        boolean firstColumn = false;
        // use first row and first column to mark
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    if (r == 0) firstRow = true;
                    if (c == 0) firstColumn = true;
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        // first row processing
        for (int c = 1; c < cols; c++) {
            if (matrix[0][c] == 0) {
                for (int r = 1; r < rows; r++) {
                    matrix[r][c] = 0;
                }
            }
        }

        // first column processing
        for (int r = 1; r < rows; r++) {
            if (matrix[r][0] == 0) {
                for (int c = 1; c < cols; c++) {
                    matrix[r][c] = 0;
                }
            }
        }

        if (firstRow) {
            for (int c = 0; c < cols; c++) {
                matrix[0][c] = 0;
            }
        }

        if (firstColumn) {
            for (int r = 0; r < rows; r++) {
                matrix[r][0] = 0;
            }
        }        
    }
}
