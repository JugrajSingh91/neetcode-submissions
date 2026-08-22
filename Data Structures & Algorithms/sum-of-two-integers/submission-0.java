class Solution {
    public int getSum(int a, int b) {
        int carry = 0;
        int res = 0;
        for (int i = 0; i <32; i++) {
            int lastBitA = (a >> i) & 1;
            int lastBitB = (b >> i) & 1;

            int curr = lastBitA ^ lastBitB ^ carry;
            carry = lastBitA + lastBitB + carry >= 2 ? 1 : 0; //if at least 2 of these are 1, there should be a carry
            res = res | (curr << i);
        }
        return res;
    }
}
