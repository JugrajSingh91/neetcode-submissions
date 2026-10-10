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

        return dfs(0, 0, startEndProfit, new HashMap<>());
    }

    int dfs(int index, int allowedAtOrAfter, int[][] startEndProfit, Map<String, Integer> memo) {
        String key = index+","+allowedAtOrAfter;
        if (memo.containsKey(key)) return memo.get(key);
        if (index == startEndProfit.length) return 0;

        if (startEndProfit[index][0] < allowedAtOrAfter) {
            return dfs(index+1, allowedAtOrAfter, startEndProfit, memo);
        }

        // skip job 
        int skip = dfs(index+1, allowedAtOrAfter, startEndProfit, memo);

        // take job
        int take = startEndProfit[index][2] + dfs(index+1, startEndProfit[index][1], startEndProfit, memo);

        int res = Math.max(skip, take);
        memo.put(key, res);
        return res;
    }
}