class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};
        Set<String> visited = new HashSet<>();
        dfsHelper(sr, sc, image, visited, directions, oldColor, color);
        return image;
    }
    
    void dfsHelper(int r, int c, int[][] image, Set<String> visited, int[][] directions, int oldColor, int color) {
        String key = r + "," + c;

        if (visited.contains(key)) {
            return;
        }

        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) {
            return;
        }

        if (image[r][c] != oldColor) {
            return;
        }

        image[r][c] = color;        
        visited.add(key);
        
        for (int[] direction: directions) {

            dfsHelper(r + direction[0], c +  direction[1], image, visited, directions, oldColor, color);
        }
        return;
    }
}