class Solution {
    private Map<Character, Set<Character>> adj;

    public String foreignDictionary(String[] words) {
        int n = words.length;
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                indegree.put(c, 0);
            }
        }
        for(int i=0;i<n-1;i++) {
            String s1 = words[i];
            String s2 = words[i+1];
            int l1 = s1.length(), l2= s2.length();
            int minlen = Math.min(l1,l2);
            if(l1 > l2 && s1.substring(0,minlen).equals(s2.substring(0,minlen))){
                return "";
            }
            for(int j=0;j<minlen;j++){
                if(s1.charAt(j) != s2.charAt(j)) {
                    if (!adj.get(s1.charAt(j)).contains(s2.charAt(j))) {
                        adj.get(s1.charAt(j)).add(s2.charAt(j));
                        indegree.put(s2.charAt(j),indegree.get(s2.charAt(j))+1);
                    }
                    break;
                }
                
            }
        }
        return topoSort(adj, indegree);
    }

    String topoSort(Map<Character, Set<Character>> adj, Map<Character, Integer> indegree) {
        Queue<Character> q = new LinkedList<Character>();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if(entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        }

        while(!q.isEmpty()) {
            Character ch = q.remove();
            sb.append(ch);
            Set<Character> characterSet = adj.get(ch);
            for(Character currCh:characterSet) {
                int currIndegree = indegree.get(currCh);
                currIndegree--;
                if(currIndegree == 0) {
                    q.add(currCh);
                }
                indegree.put(currCh, currIndegree);
            }
        }
        if (sb.length() != indegree.size()) {
            return "";
        }
        return sb.toString();
    }
}
