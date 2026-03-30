class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[256];
        int ans = 0;
        for(int i=0;i<256;i++) count[i] = -1;
        int left = 0, right = 0;
        for(int i=0;i<s.length();i++) {
            if(count[s.charAt(i)] != -1) {
                left = Math.max(count[s.charAt(i)]+1, left);
            }
            count[s.charAt(i)] = i;
            right++;
            int curr = right - left;
            if(curr > ans) ans = curr;
        }
        int curr = right - left;
        if(curr > ans) ans = curr;
        return ans;
    }
}
