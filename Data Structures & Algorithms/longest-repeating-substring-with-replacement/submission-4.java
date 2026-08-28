class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int result = 0;
        int maxf = 0;
        int l = 0;
        for(int r = 0; r <s.length(); r++) {
            int currFreq = map.getOrDefault(s.charAt(r), 0) + 1 ;
            map.put(s.charAt(r),currFreq );
            if(maxf < currFreq) {
                maxf = currFreq;
            }

            if( (r - l + 1) - maxf > k ) {
                map.put(s.charAt(l), map.get(s.charAt(l)) -1);
                l++;
            }
            result = Math.max(result, r - l +1);
        }
        return result;
    }
}
