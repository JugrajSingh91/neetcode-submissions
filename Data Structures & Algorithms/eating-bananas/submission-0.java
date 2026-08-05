class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
         int left = 1;
        int max = 0;

        for (int apple: piles) {
            max = Math.max(max, apple);
        }

        int answer = max;

        int right  = max;
        
        while (left <= right) {
            int mid = left + (right - left) /2;
            if (canBobbyFinish(piles, mid, h)) {
                answer = Math.min(answer, mid);
                right  = mid - 1;
            } else {left = mid + 1;}
        }

        return answer;
    }

    private boolean canBobbyFinish(int[] apples, int speed, int deadline) {
        int time = 0;

        for (int i = 0; i < apples.length; i++ ) {
            time += apples[i]/speed;
            time += apples[i] % speed == 0 ? 0 : 1;
        }

        return time <= deadline ? true : false;
    }
}
