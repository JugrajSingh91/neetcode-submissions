class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> res = new ArrayList<>();
        Set<String> words = new HashSet<>(wordDict);
        dfs(s, 0, "", new ArrayList<>(), words, res);
        // convert List<String> to Strings
        List<String> sentences = new ArrayList<>();
        for (List<String> list : res) {
            String sentence = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                sentence += " " + list.get(i);
            }
            sentences.add(sentence);
        }
        return sentences;
    }

    void dfs(String s, int index, String wordSoFar, List<String> pathSoFar, Set<String> words, List<List<String>> res) {
        // we finished the string 
        if (index == s.length()) {
            // if wordSoFar == "", that means the last char was part of a dict word added to pathSoFar, 
            // so we have a valid part of the ans
            if (wordSoFar.equals("")) res.add(new ArrayList<>(pathSoFar));
            return;
        }
        
        wordSoFar += s.charAt(index);
        if (words.contains(wordSoFar)) {
            // take it 
            pathSoFar.add(wordSoFar);
                // start creating new word from next index
            dfs(s, index+1, "", pathSoFar, words, res);

            // keep looking
            pathSoFar.remove(pathSoFar.size()-1);
            dfs(s, index+1, wordSoFar, pathSoFar, words, res);
        } else {
            dfs(s, index+1, wordSoFar, pathSoFar, words, res);
        }

    }
}