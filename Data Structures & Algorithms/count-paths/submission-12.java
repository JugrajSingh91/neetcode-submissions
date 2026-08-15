class Solution {

    //bottom up [optimal using two rows]
    public int uniquePaths(int m, int n) {
        int[] prevRow = new int[n];
        prevRow[n-1] = 1;

        for (int r = m-1; r >= 0; r--) {
            int[] newRow = new int[n]; 
            newRow[n-1] = 1; // always 1 for last column
            for (int c = n-2; c >= 0; c--) {
                //from right
                newRow[c] = prevRow[c] + newRow[c+1];
                
            }
            prevRow = newRow;
        }
        return prevRow[0];
    }
}
