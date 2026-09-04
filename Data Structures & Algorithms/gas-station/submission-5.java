class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tGas = 0;
        int tCost = 0;
        for (int g : gas) tGas += g;
        for (int c: cost) tCost += c;
        
        // if total gas < total gas there is no way the whole circuit can completed
        // no matter the starting point
        if (tCost > tGas) return -1;

        int total = 0; // total gas  = gas collected so far + gas found - cost of gas to reach next destination
        int startIndex = 0; // start with index 0 and try
        for (int i = 0; i < cost.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) { //
                total = 0; // reset gas tank

                // try to start from next index
                // why start from next index and not the current index?
                // A: because we reached the current index with >=0 tank of gas from previous
                // station and still couldn't move forward, so the current index
                // cannot be the start index
                startIndex = i+1; 
            }
        }
        return startIndex;
    }
}
