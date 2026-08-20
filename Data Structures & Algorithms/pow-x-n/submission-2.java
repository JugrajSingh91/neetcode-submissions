class Solution {
    /*
    * Think of 5^9 as an example.
    * The exponent 9 in binary is 1001
    * 5^9 =  5^8 * 5^0 * 5^0 * 5^ 1 (the exponents increase 1, 2, 4, 8, 16.... from right to left)
    * dividing the exponent by 2 gets rid of the rightmost bit
    * (1) Check if right most bit is 1 (using % to find remainder)
    * (2) If it is 1, append base to answer i.e. ans = ans* base;
    * (3) square base
    * (4) half exponent to remove the right most bit
    */
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        
        // to prevent the edge where Integer.MIN_VALUE cant be converted to positive value but it stays negative
        long N =  Math.abs((long) n);

        double ans = 1.0;
        double curr = x;
        while(N > 0) {
            if (N % 2  == 1) ans *= curr;
            curr *= curr;
            N /= 2;
        }

        return (n > 0)? ans : 1 / ans;
    }
}



/*In Java, a standard 32-bit int has a strict range:
- Maximum value: 2,147,483,647
- Minimum value: -2,147,483,648

Notice that the negative side has one extra number.Because of this asymmetry, if you try to make -2,147,483,648 positive by using Math.abs() or multiplying by -1, Java looks for +2,147,483,648. However, that number is too big to fit in a standard integer!
Instead of throwing an error, the bits overflow and wrap right back around. In Java, Math.abs(Integer.MIN_VALUE) literally returns -2,147,483,648. It stays negative.*/
