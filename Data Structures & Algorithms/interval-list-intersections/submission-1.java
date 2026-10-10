class Solution {
    // Line sweep algorithm
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> events = new ArrayList<>();
        for (int[] event: firstList) {
            int start = event[0];
            int end = event[1];

            // type 1 event means START
            // type -1 event means END
            // 1 and -1 help keep track of active events
            events.add(new int[]{start, 1});
            events.add(new int[]{end, -1});
        }

        for (int[] event: secondList) {
            int start = event[0];
            int end = event[1];

            // type 1 event means START
            // type -1 event means END
            // 1 and -1 help keep track of active events
            events.add(new int[]{start, 1});
            events.add(new int[]{end, -1});
        }

        events.sort((a, b) -> {
            // if two events START and END at the same time, we want to process START before END
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            // otherwise sort in ascending order
            return Integer.compare(a[0], b[0]);
        });

        int active = 0;
        int startPosition = -1;
        List<int[]> res = new ArrayList<>();
        for (int[] event: events) {

            // type 1 is START of event
            if (event[1] == 1) {
                active++;
                if (active == 2) startPosition = event[0];
            // END event
            // if we were in an overlapping region (active == 2)
            // this event would close it    
            } else {
                if (active == 2) res.add(new int[]{startPosition, event[0]});
                active--;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}