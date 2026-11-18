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

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        for (int i = 0; i < n; i++) {
            startTimes[i] = intervals.get(i).start;
            endTimes[i] = intervals.get(i).end;
        } 
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int rooms = 0;
        int start = 0, end = 0;
        int maxRooms = 0;
        // need to make sure all meetings start
        while(start < n) {
            // 0, 5, 15 startTimes
            // 10, 20, 40 endTimes
            if (startTimes[start] < endTimes[end]) {
                rooms++;
                start++;
            } else {
                rooms--;
                end++;
            }
            maxRooms = Math.max(rooms, maxRooms);
        }
        return maxRooms;
    }
}
