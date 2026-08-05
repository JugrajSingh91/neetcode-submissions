class Solution {
    public int reverseBits(int n) {
        int index = 0;
        int res=0;
        for (int i = 0; i < 32; i++) {
            int lsb = n&1;
            res = (res << 1) + lsb;
            n = n >> 1;
        }
        return res;
    }
}
