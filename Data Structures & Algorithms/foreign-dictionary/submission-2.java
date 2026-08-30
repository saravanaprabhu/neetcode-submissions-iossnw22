class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character, Set<Character>> adjList = new HashMap<Character, Set<Character>>();
        HashMap<Character, Integer> indegree = new HashMap<Character, Integer>();
        Queue<Character> q = new LinkedList<Character>();
        for(String word : words) {
            for(char ch: word.toCharArray()) {
                adjList.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }
        for(int i = 0; i< words.length-1;i++) {
            int minLen = Math.min(words[i].length(), words[i+1].length());
            if(words[i].length() > words[i+1].length()
             && words[i].substring(0,minLen).equals(words[i+1].substring(0,minLen))) {
                return "";
            }
            for(int j = 0; j < minLen ; j++) {
                if(words[i].charAt(j)!= words[i+1].charAt(j)) {
                    if(!adjList.get(words[i].charAt(j)).contains(words[i+1].charAt(j)))   {
                        adjList.get(words[i].charAt(j)).add(words[i+1].charAt(j));
                        indegree.put(words[i+1].charAt(j), indegree.get(words[i+1].charAt(j)) + 1);
                    }
                    break;
                }
            }
        }

        for(char c:indegree.keySet()) {
            if(indegree.get(c) == 0) {
                q.offer(c);
            }
        }
        StringBuilder res = new StringBuilder();
        while(!q.isEmpty()) {
            char ch = q.poll();
            res.append(ch);
            for(char neighbour: adjList.get(ch)) {
                indegree.put(neighbour, indegree.get(neighbour) - 1);
                if(indegree.get(neighbour) == 0 ) {
                    q.offer(neighbour);
                }
            }
        }
        if(res.length() != indegree.size()) {
            return "";
        }
        return res.toString();

    }
}
