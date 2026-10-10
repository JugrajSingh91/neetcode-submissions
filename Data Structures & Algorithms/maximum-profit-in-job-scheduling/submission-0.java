class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // sort all start, end, and profit based on startTime
        int[][] startEndProfit = new int[startTime.length][3]; //{start, end, profit}
        for (int i = 0; i < startTime.length; i++) {
            startEndProfit[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(startEndProfit, (a,b) -> {
            return Integer.compare(a[0], b[0]);
        });

        return dfs(0, 0, startEndProfit);
    }

    int dfs(int index, int allowedAtOrAfter, int[][] startEndProfit) {
        if (index == startEndProfit.length) return 0;

        if (startEndProfit[index][0] < allowedAtOrAfter) {
            return dfs(index+1, allowedAtOrAfter, startEndProfit);
        }

        // skip job 
        int skip = dfs(index+1, allowedAtOrAfter, startEndProfit);

        // take job
        int take = startEndProfit[index][2] + dfs(index+1, startEndProfit[index][1], startEndProfit);

        return Math.max(skip, take);
    }
}