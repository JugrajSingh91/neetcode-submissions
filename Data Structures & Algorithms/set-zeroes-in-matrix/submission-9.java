class Solution {
    public void setZeroes(int[][] matrix) { 
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColumnZero = false;

        // mark first column zero
        for (int r = 0; r < rows; r++) {
            if (matrix[r][0] == 0) {
                firstColumnZero = true;
            }
        }

        // mark first row zero
        for (int c = 0; c < cols; c++) {
            if (matrix[0][c] == 0) {
                firstRowZero = true;
            }
        }

        // mark first row and first column as 0 to flag the rows and columns that
        // need to be updated to 0
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    matrix[r][0] = 0;
                }
            }
        }

        // use the first row and column to update the rows and columns
        // that need to be marked 0
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[0][c] == 0 || matrix[r][0] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        // update first row if first row needs to be updated with 0s
        if (firstRowZero) {
            for (int c = 0; c < cols; c++) {
                matrix[0][c] = 0;
            }
        }

        // update first columns if first column needs to be updated with 0s
        if (firstColumnZero) {
            for (int r = 0; r < rows; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}
