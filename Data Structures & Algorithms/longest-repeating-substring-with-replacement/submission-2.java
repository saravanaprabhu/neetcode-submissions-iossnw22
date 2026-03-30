class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, result = 0, maxf = 0;
        for(int right=0;right<s.length();right++) {
            count[s.charAt(right)-'A']++;
            maxf = Math.max(maxf, count[s.charAt(right)-'A']);
            while( right - left + 1 - maxf > k) {
                count[s.charAt(left++)-'A']--;
            }
            result = Math.max(result , right - left + 1);
        }
        return result;
    }
}
