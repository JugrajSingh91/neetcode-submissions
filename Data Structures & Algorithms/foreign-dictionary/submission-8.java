class Solution {
    public String foreignDictionary(String[] words) {
      // data structure to count indegrees 
      int[] indegree = new int[26];
      Arrays.fill(indegree, -1);

    for (String word: words) {
        for (char c: word.toCharArray()) {
            if (indegree[c-'a'] == -1) indegree[c-'a'] = 0;
        }
    }
      
      // Using a set here so that everytime an edge is found u -> v before increasing the indegree of v we should make sure that u->v edge is unique, otherwise we would do redundant increments. 
      //For example, "he" "she" creates a h -> s edge with indegree of s increasing by one, but if we see another pair like him -> shit we should ignore this edge, other we erroneously increase the idegree of s, and Kahn's algorithm will not work as it's indegree will not come down to 0
      Map<Integer, Set<Integer>> adjList = new HashMap<>();

      for (int i = 1; i < words.length ; i++) {
        String a = words[i-1];
        String b = words[i];

        // if b is a prefix of a, that's invalid
        if (a.length() > b.length() && a.startsWith(b)) return "";

        int minLen = Math.min(a.length(), b.length());
        for (int j= 0; j < minLen; j++) {
            char u = a.charAt(j);
            char v = b.charAt(j);
            if (u != v) {
                // if u already v as it's neighbor we can't increase indegree of v
                if (!adjList.getOrDefault(u-'a', new HashSet<>()).contains(v-'a')) {
                    adjList.computeIfAbsent(u-'a', k -> new HashSet<>()).add(v-'a');
                    indegree[v-'a']++;
                }
                break;
            }
        }
      }

      Queue<Integer> q = new LinkedList<>();
      int totalChars = 0;
      for (int i = 0; i < 26; i++) {
        if (indegree[i] == 0) {
            q.offer(i);
            
        }
        if (indegree[i]!=-1) totalChars++;
      }
    
      StringBuilder sb = new StringBuilder();
      while(!q.isEmpty()) {
        int node = q.poll();
        sb.append((char) ('a'+node));
        for (int neighbor: adjList.getOrDefault(node, new HashSet<>())) {
            indegree[neighbor]--;
            if (indegree[neighbor] == 0) q.offer(neighbor);
        }
      }
      if (sb.length() == totalChars) return sb.toString();
      return "";
    }
}
