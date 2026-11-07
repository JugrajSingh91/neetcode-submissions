/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

// SweepLine algorithm
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int[] startTimes = new int[intervals.size()];
        int[] endTimes = new int[intervals.size()];

        int i = 0;
        for (Interval interval: intervals) {
            startTimes[i] = interval.start;
            endTimes[i] = interval.end;
            i++;
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int max = 0;
        int concurrent = 0;
        int s = 0, e = 0;

        // repeat until all meetings have started
        while(s < intervals.size()) {
            if (startTimes[s] < endTimes[e]) {
                concurrent++;
                s++;
            } else {
                concurrent--;
                e++;
            }
            max = Math.max(concurrent, max);
        }
        return max;
    }
}
