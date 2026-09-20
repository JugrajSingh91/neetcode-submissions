class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        Map<Character, Integer> tFreq = new HashMap<>(); 
        for (char c: t.toCharArray()) tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);

        Map<Character, Integer> nFreq = new HashMap<>();

        int l = 0;
        int have  = tFreq.size(); // total unique characters 
        // we will increment need only if a character is present in tFreq and matches or exceeds its count
        int need = 0; 
        int[] resultIndices = new int[2];
        int resStringLenMin = Integer.MAX_VALUE;
        for (int r = 0; r < s.length(); r++) {
            char rChar = s.charAt(r); 
            
            //increase need count if 
            // 1. tFreq has curr && 
            // 2. curr count equals or exceeds curr count in tFreq
            if (tFreq.containsKey(rChar)){
                nFreq.put(rChar, nFreq.getOrDefault(rChar, 0) + 1);
                if (nFreq.get(rChar).equals(tFreq.get(rChar))) need++;
            } 

            // we have a substring in s which contains t, let's try to squeeze the 
            // left index to minimize its length as long as the substring can containt t
            while(need == have) {
                int currLen = r - l + 1; 
                if (currLen < resStringLenMin) {
                    resStringLenMin = currLen; 
                    resultIndices[0] = l; 
                    resultIndices[1] = r; 
                }
                char lChar = s.charAt(l); 
                if (tFreq.containsKey(lChar)){
                    nFreq.put(lChar, nFreq.getOrDefault(lChar, 0) - 1);
                    if (nFreq.get(lChar) < tFreq.get(lChar)) need--;
                } 
                l++;
            }
        } 
        return (resStringLenMin == Integer.MAX_VALUE)? "" : s.substring(resultIndices[0], resultIndices[1]+1);
    }
}
