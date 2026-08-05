class Solution {
    public String minWindow(String s, String t) {
        // s = "xyz", t = "xyz"

        if (t.length() > s.length()) return "";
        Map<Character, Integer> tFreq = new HashMap<>();

        for (char c: t.toCharArray()) { //tFreq {x: 1, y: 1, z: 1}
            int freq = tFreq.getOrDefault(c, 0);
            tFreq.put(c, freq + 1);
        }

        int l = 0, r = 0;
        Map<Character, Integer> sFreq = new HashMap(); // sFreq {}
        String res = "";
        int len = Integer.MAX_VALUE;
                
        while (r < s.length() || matches(sFreq, tFreq)) { // slength = 3
            
            if (!matches(sFreq, tFreq)) { 
                char curr = s.charAt(r); // xy/ 
                int freq = sFreq.getOrDefault(curr, 0); 
                sFreq.put(curr, freq + 1); // sFreq {x: 1, y: 1, z: 1}
                r++; // r 3
                continue;
            } else { // we found a string  // UDYXAZ
                if ( r - l   < len) {
                    len = r - l; // 4
                    res =  s.substring(l,r); // YXAZ
                }
                 // l 1
                // reduce first char freq from map. remove if fre is 0
                char firstChar = s.charAt(l);
                int freq = sFreq.get(firstChar);
                if (freq == 1) {
                    sFreq.remove(firstChar);
                } else {
                    sFreq.put(firstChar, freq - 1);
                }
                l++;
            }
        }
        return res;
    }

    boolean matches (Map<Character, Integer> sFreq, Map<Character, Integer> tFreq) {
        for (Map.Entry<Character, Integer> e: tFreq.entrySet()) {
            char key = e.getKey();
            int value = e.getValue();
            if (!sFreq.containsKey(key) || sFreq.get(key) < value) return false;
        }
        return true;
    }
}
