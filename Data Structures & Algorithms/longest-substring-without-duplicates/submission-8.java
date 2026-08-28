class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int result = 0;
        int l = 0, r = 0; 
        for(char ch: s.toCharArray()) {
            if(map.containsKey(ch)) {
                int lastIndex = map.get(ch) ;
                if( l < lastIndex + 1) {
                    l = lastIndex + 1;
                }
                map.put(ch, r);
            } else {
                map.put(ch, r);
            }
            if(result < r - l + 1 ) {
                result = r - l +1;
            }
            r++;
        }
        return result;
    }
}
