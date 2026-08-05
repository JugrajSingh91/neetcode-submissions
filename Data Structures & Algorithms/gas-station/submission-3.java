class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int fuel = 0;
        int start = 0;
        int total = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            fuel += diff;
            if (fuel < 0) {
                fuel = 0;
                start = i + 1;
            }
        }
        return (total < 0)? -1 : start;
    }
}
