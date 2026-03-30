class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        Map<Character, Integer> count = new HashMap<Character, Integer>();
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        if(t.length() > s.length()) return "";
        for(int i=0;i<t.length();i++) {
            count.put(t.charAt(i), count.getOrDefault(t.charAt(i), 0) + 1);
        }
        int have = 0, need = count.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;
        for(int r=0;r<s.length();r++) {
            window.put(s.charAt(r), window.getOrDefault(s.charAt(r),0)+1);
            if(count.containsKey(s.charAt(r)) && 
                window.get(s.charAt(r)).equals(count.get(s.charAt(r)))) {
                have++;
            }
            while(have == need) {
                if((r-l+1) < resLen) {
                    resLen = r-l+1;
                    res[0] = l;
                    res[1] = r;
                }
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar)-1);
                if(count.containsKey(leftChar) && 
                    window.get(leftChar) < count.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
