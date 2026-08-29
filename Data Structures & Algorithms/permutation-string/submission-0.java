class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Populate count for s1 and the first window of s2
        for (int i = 0; i < n1; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        // Slide the window across s2
        for (int i = 0; i <= n2 - n1; i++) {
            if (matches(count1, count2)) {
                return true;
            }
            // Move window forward: remove outgoing char, add incoming char
            if (i < n2 - n1) {
                count2[s2.charAt(i) - 'a']--;
                count2[s2.charAt(i + n1) - 'a']++;
            }
        }

        return false;
    }

    boolean matches(int[] c1, int[] c2) {
        for(int i=0;i<26;i++) {
            if(c1[i] != c2[i])return false;
        }
        return true;
    }
}
