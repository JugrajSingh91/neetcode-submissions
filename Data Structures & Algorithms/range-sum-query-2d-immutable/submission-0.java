class NumMatrix {
    int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        prefixSum = new int[matrix.length][matrix[0].length];
        for (int r = 0; r < matrix.length; r++) {
            prefixSum[r][0] = matrix[r][0];
            for (int c = 1; c < matrix[0].length; c++) {
                prefixSum[r][c] = matrix[r][c] + prefixSum[r][c-1];
            }
        }
    }

    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for (int r = row1; r<=row2; r++) {
            if (col1 == 0) {
                ans += prefixSum[r][col2];
            } else {
                ans += prefixSum[r][col2] - prefixSum[r][col1-1];
            }
            
        }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */