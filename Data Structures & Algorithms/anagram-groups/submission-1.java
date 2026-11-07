class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String s: strs) {
            int[] counter = new int[26];
            for (char c: s.toCharArray()) {
                counter[c-'a']++;
            }
            

            // THIS IS AMAZING
            String key = Arrays.toString(counter);
            anagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> list: anagrams.values()) res.add(list);
        return res;
    }
}
