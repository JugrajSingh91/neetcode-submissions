class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        
        while(n > 1) {
            if (!seen.add(n)) return false;
            int newN = 0;
            while (n > 0) {
                int r = n%10;
                newN += Math.pow(r, 2);
                n = n/10;
            }
            n = newN;
        }
        return true;
    }
}
