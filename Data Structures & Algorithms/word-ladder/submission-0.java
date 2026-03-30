class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.isEmpty()) return 0;
        Set<String> set = new HashSet<>();
        for(int i = 0;i < wordList.size(); i++) {
             set.add(wordList.get(i)); 
        }
        if(!set.contains(endWord)) return 0;
        if(beginWord.equals(endWord)) return 1;
         List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        createGraph(adjList, wordList, beginWord);
        return doBfs(adjList, wordList, endWord);
    }

    private void createGraph(  List<List<Integer>> adjList , List<String> wordList, String beginWord ) {
        for(int i = 0 ; i < wordList.size() + 1 ; i++ ) {
            adjList.add(new ArrayList<Integer>());
            String word1 = (i == 0) ? beginWord : wordList.get(i - 1);
            for( int j = 0; j < wordList.size(); j++ ) {
                if(diff(word1, wordList.get(j)) == 1) {

                    adjList.get(i).add(j+1);
                }
            }
        }
    }


    int doBfs( List<List<Integer>> adjList, List<String> wordList, String endWord ) {
        Queue<Integer> q = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        q.add(0);
        visited.add(0);

        int level = 1;
        while( !q.isEmpty() ) {
            int size = q.size();
            level++;
            while( size-- > 0 ) {
                int currNode = q.remove();
                List<Integer> childNode = adjList.get(currNode);
                for(int i = 0; i< childNode.size(); i++ ) {
                    int neighborIdx = childNode.get(i);
                    if( !visited.contains(neighborIdx)) {
                        if (wordList.get(neighborIdx - 1).equals(endWord)) {
                            return level;
                        }
                        q.add(neighborIdx);
                        visited.add(neighborIdx);
                    }

                }
            }
        }
        return 0;
    }

    int diff(String word1, String word2) {
        int i = 0 ;
        int count = 0;
        while( i < word1.length() && i < word2.length() ) {
            if(word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
            i++;
        }
        return count;
    }
}
