class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String s: strs) {
            int[] counter = new int[26];
            for (char c: s.toCharArray()) {
                counter[c-'a']++;
            }

            String key = "";
            for (int i = 0; i < 26; i++) {
                if (counter[i] > 0) {
                    String add = 'a' + i + String.valueOf(counter[i]);
                    key += add;
                }
            }

            anagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> list: anagrams.values()) res.add(list);
        return res;
    }
}
