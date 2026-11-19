class Solution {
    public void setZeroes(int[][] matrix) {


          boolean firstColumnZero = false;
          boolean firstRowZero = false;
          int rows = matrix.length;
          int cols = matrix[0].length;

          // check first col
          for (int r = 0; r < rows; r++) {
            if (matrix[r][0] == 0) {
                firstColumnZero = true;
                break;
            }
          }

          // check first row
          for (int c = 0; c < cols; c++) {
            if (matrix[0][c] == 0) {
                firstRowZero = true;
                break;
            }
          }

          for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0; // mark first col
                    matrix[0][c] = 0; // mark first col
                }
            }
          }

          for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                // check first row
                if (matrix[0][c] == 0) {
                    // paint full column 0
                    for (int row = 0; row < rows; row++) {
                        matrix[row][c] =0;
                    }
                }
                // check first col
                if (matrix[r][0] == 0) {
                    // paint full row 0
                    for (int col = 0; col < cols; col++) {
                        matrix[r][col] =0;
                    }
                }
            }
          }

          if (firstColumnZero) {
            // paint full column 0
                    for (int r = 0; r < rows; r++) {
                        matrix[r][0] =0;
                    }
          }

          if (firstRowZero) {
            // paint full column 0
                    for (int c = 0; c < cols; c++) {
                        matrix[0][c] =0;
                    }
          }
    }
}
