class Solution {
    // [1] recursion and top down memoization
    public int mincostTickets(int[] days, int[] costs) {
        int[] duration = new int[]{1 ,7 ,30};
        return dfs(days, 0, costs, 0, duration, new HashMap<>());
    }

    int dfs(int[] days, int dayIndex, int[] costs, int ticketIndex, int[] duration, Map<String, Integer> memo) {
        if (dayIndex == days.length) return 0;

        // dayIndex is not zero since that base case is covered
        if (ticketIndex >= costs.length) {
            return Integer.MAX_VALUE/2;
        } 

        String key = dayIndex + "," + ticketIndex;
        if (memo.containsKey(key)) return memo.get(key);

        // skip ticket, try the next more expensive ticket [1 day, 7 days, 30 days]
        int skip = dfs(days, dayIndex, costs, ticketIndex + 1, duration, memo);

        // Calculate dayIndex if ticket is consumed
        int freeDays = duration[ticketIndex];
        int ticketExpiryDay = days[dayIndex] + freeDays;
        while(dayIndex < days.length && days[dayIndex] < ticketExpiryDay) {
            dayIndex++;
        }

        // include ticket cost
        int include = costs[ticketIndex] + dfs(days, dayIndex, costs, 0, duration, memo); // reset ticket index so that all ticket options are available

        int result = Math.min(skip, include);
        memo.put(key, result);
        return result;
    }
}