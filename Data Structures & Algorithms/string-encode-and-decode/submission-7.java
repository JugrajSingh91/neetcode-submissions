class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();

        for (String s: strs) {
            res.append(s.length()).append("#").append(s);
        }

        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
// Hello","World"
// "5Hello5World"
        for (int i = 0; i < str.length();) {
            // extract string length
            int length = 0;
            while(str.charAt(i) != '#') {
                length = length*10 + (Character.getNumericValue(str.charAt(i))); // 34
                i++; // 2
            }

            int left = i+1;
            int right = left + length;
            String s = str.substring(left, right);
            res.add(s);
            i = right;
        }
        return res;
    }
}
