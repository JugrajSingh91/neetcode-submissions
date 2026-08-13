class Solution {
    //Djisttra we need to adapt it such that we find the shortest distance from top left to bottom right
    // Definition of shortest is the path which has least peak height
    // So we maintain a priority queue which records the least peak height needed to reach that node
    public int swimInWater(int[][] grid) {

        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> {
            return Integer.compare(a[0], b[0]); // {height, r,c} // min Peak Height to reach that node
        });

        // min peak height to reach each node where node is "r,c"
        Map<String,Integer> minPeakHeight = new HashMap<>();
        
        heap.offer(new int[]{grid[0][0], 0, 0});
        minPeakHeight.put("0,0", grid[0][0]);

        while(!heap.isEmpty()) {
            int[] current = heap.poll();
            int h = current[0];
            int r = current[1];
            int c = current[2];

            String key = r + "," + c;

            //Lazy deletion if we already have a lower peak height for the key
            if (h > minPeakHeight.getOrDefault(key, Integer.MAX_VALUE)) continue;

            for (int[] d: directions) {
                int nRow = r + d[0];
                int nCol = c + d[1];
                if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length) {
                    String newKey = nRow + "," + nCol;
                    int gridValue = grid[nRow][nCol];

                    // newKey has not been visited
                    if (!minPeakHeight.containsKey(newKey)) { 
                        minPeakHeight.put(newKey, Math.max(gridValue, h));
                        heap.offer(new int[]{Math.max(gridValue, h), nRow, nCol});
                    // key has been visited before    
                    } else { 
                        int existingH = minPeakHeight.get(newKey);
                        if (h >= gridValue && h < existingH) {
                            minPeakHeight.put(newKey, h);
                            heap.offer(new int[]{h, nRow, nCol});
                        }
                    }
                }
            }
        }
        int brRow = grid.length - 1;
        int brCol = grid[0].length - 1;
        return minPeakHeight.get(brRow+","+brCol);
    }
}
