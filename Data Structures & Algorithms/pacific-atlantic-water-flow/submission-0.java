class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<String> pacific = new HashSet<>();
        Set<String> atlantic = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        if (heights == null || heights.length == 0) return result;

        int rows = heights.length;
        int cols = heights[0].length;


        // traverse pacific coast
        for (int c = 0; c < cols; c++) {
            dfsHelper(0, c, directions, heights, pacific);
        }
        for (int r = 0; r < rows; r++) {
            dfsHelper(r, 0, directions, heights, pacific);
        }

        // traverse atlantic coast
        for (int c = 0; c < cols; c++) {
            dfsHelper(rows-1, c, directions, heights, atlantic);
        }
        for (int r = 0; r < rows; r++) {
            dfsHelper(r, cols-1, directions, heights, atlantic);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                String key = r + "," + c;
                if (pacific.contains(key) && atlantic.contains(key)) {
                    result.add(new ArrayList<>(List.of(r, c)));
                }
            }
        }
        return result;
    }

    void dfsHelper(int r, int c, int[][] directions, int[][] heights, Set<String> shore ) {
        String key = r + "," + c;
        //if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length) {
        //    return;
        //}

        if (shore.contains(key)) {
            return;
        }

        shore.add(key);

        for (int[] d: directions) {
            int newRow = r+d[0];
            int newCol = c+d[1];
            if (newRow < 0 || newRow >= heights.length || newCol < 0 || newCol >= heights[0].length) {
                continue;
            }
            if (heights[r+d[0]][c+d[1]] >= heights[r][c]) {
                dfsHelper(r+d[0], c+d[1], directions, heights, shore);
            }
        }
        return;
    }
}
