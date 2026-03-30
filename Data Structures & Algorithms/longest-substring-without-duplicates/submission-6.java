class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charLastIndex = new HashMap<Character, Integer>();
        int result = 0;
        int startIndex = 0;
        int endIndex = 0;
        for( int i = 0 ; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(charLastIndex.containsKey(ch)) {
                startIndex = Math.max(startIndex, charLastIndex.get(ch) + 1);
            }
            charLastIndex.put(ch, i);
            
            result = Math.max(i + 1 - startIndex, result);
        }
        return result;
    }
}
