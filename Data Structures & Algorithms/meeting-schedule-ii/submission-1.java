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
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n ; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int startMeetingIndex = 0;
        int endMeetingIndex = 0;
        int max = 0;
        int concurrentMeetings = 0;


        // best test case; Intervals: [[1, 4], [2, 5], [6, 10]]
        while(startMeetingIndex < n) {
            if (start[startMeetingIndex] < end[endMeetingIndex]) {
                concurrentMeetings++; // a new meeting started
                startMeetingIndex++;
            } else {
                concurrentMeetings--; // a meeting ended
                endMeetingIndex++; 
            }
            max = Math.max(max, concurrentMeetings);
        }
        return max;
    }
}
