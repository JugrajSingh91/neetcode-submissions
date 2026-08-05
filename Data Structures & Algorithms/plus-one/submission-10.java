class Solution {
    public int[] plusOne(int[] digits) { // 999
        int carry = 1;
        int digit = 0;
        List<Integer> res = new ArrayList<>();
        for (int i  = digits.length - 1; i>=0; i--) { // 2, 1, 0
            digit = digits[i] + carry; // 10
            
            if (digit >= 10) {
                carry = digit / 10; // 1
                digit = digit % 10; // 0
            } else {
                carry = 0;
            }
            res.add(digit); // [0, 0]
        }
        if (carry !=0 ) res.add(carry);
        int[] result = new int[res.size()];
        int index = res.size() - 1;
        for (int r: res) {
            result[index] = r;
            index--;
        }
    return result;
    }
}
