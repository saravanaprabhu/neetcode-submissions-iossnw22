class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> countT = new HashMap<Character, Integer>();
        if(t.length()  > s.length()) return "";
        
        for(char ch: t.toCharArray()) {
            countT.put(ch, countT.getOrDefault(ch,0) + 1);
        }
        int need = countT.size() , have = 0;
        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int lResultIndex = 0; 
        int r = 0;
        for( r = 0 ;  r < s.length(); r++) {
            if(countT.containsKey(s.charAt(r))) {
                int remainingChars = countT.get(s.charAt(r)) - 1;
                if(remainingChars == 0) {
                    have++;
                }
                countT.put(s.charAt(r),remainingChars);
            }
            while( need == have ) {
                if( r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    lResultIndex = l;
                }
                char leftChar = s.charAt(l);
                if(countT.containsKey(leftChar)) {
                    if(countT.get(leftChar) == 0) {
                        have--;
                    }
                    countT.put(leftChar, countT.get(leftChar) + 1);

                } 
                l++;
            }
        }
        if(minLen < Integer.MAX_VALUE) {
            return s.substring(lResultIndex,  lResultIndex + minLen);
        } else {
            return "";
        }
    }
}
