class Solution {
    public boolean isPalindrome(String s) {
        char[] charArr = s.toCharArray();
        int left = 0 , right = charArr.length-1;
        while ( left < right ) {
            System.out.println(charArr[left]);
            System.out.println(charArr[right]);
            if(!isAlphaNumeric(charArr[left])) {
                left++;
                continue;
            }
            if(!isAlphaNumeric(charArr[right])) {
                right--;
                continue;
            }
            if(Character.toLowerCase(charArr[left]) != Character.toLowerCase(charArr[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    
    boolean isAlphaNumeric(char ch) {
        return (ch >= 'a' && ch <= 'z') || 
            (ch >= 'A' && ch <= 'Z') || 
            (ch >= '0' && ch <= '9');
    }
}
