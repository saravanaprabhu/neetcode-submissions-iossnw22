class PrefixTree {
    class TrieNode {
        TrieNode[] next;
        boolean isEndWord;
        TrieNode() {
            this.next = new TrieNode[26];
            this.isEndWord = false;
        }
    }
    TrieNode root = null;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode traverse = root;
        for( int i = 0; i< word.length(); i++) {
            char currentCh = word.charAt(i);
            if(traverse.next[currentCh-'a'] == null) {
                TrieNode newNode = new TrieNode();
                traverse.next[currentCh-'a'] = newNode;
                traverse = traverse.next[currentCh-'a'];
            } else {
                traverse = traverse.next[currentCh-'a'];
            }
        }
        traverse.isEndWord = true;
    }

    public boolean search(String word) {
        TrieNode traverse = root;
        for( int i = 0; i < word.length() ; i++ ) {
            char currentCh = word.charAt(i);
            if(traverse.next[currentCh-'a'] != null) {
                traverse = traverse.next[currentCh-'a'];
            } else {
                return false;
            }
        }
        return traverse.isEndWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode traverse = root;
        for( int i = 0; i < prefix.length() ; i++ ) {
            char currentCh = prefix.charAt(i);
            if(traverse.next[currentCh-'a'] != null) {
                traverse = traverse.next[currentCh-'a'];
            } else {
                return false;
            }
        }
        return true;
    }
}
