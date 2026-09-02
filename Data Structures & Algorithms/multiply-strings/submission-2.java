class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        //num1 "1236"
        //num2 "52"

        //1236*2 = 2472
        //1236*5 = 6180*10 + 2472

        int n1 = num1.length();
        int n2 = num2.length();

        if (n1 > n2) return multiply(num2, num1);

        int zeroCount = 0;
        String res = "";
        for (int i = n2-1; i >= 0; i--) {
            // mutiply num1 * num2.charAt(i)
            String multiple = multi(num1, num2.charAt(i));
            // add zeros
            multiple = multiple + "0".repeat(zeroCount);
            // add to the previous value
            res = add(multiple, res);
            zeroCount++;
        }
        return res;
    }

    String add(String s1, String s2) {
        int i = s1.length()-1; int j = s2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0 || carry > 0) {
            int n1 = (i >= 0)? s1.charAt(i) - '0' : 0;
            int n2 = (j >= 0)? s2.charAt(j) - '0' : 0;
            int t = n1+n2+carry;
            sb.append(t%10);
            carry = t/10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }

    String multi(String s, char t) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >=0;i--) {
            char c = s.charAt(i);
            int product = (c - '0') * (t - '0') + carry;
            sb.append(product%10);
            carry = product/10;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
