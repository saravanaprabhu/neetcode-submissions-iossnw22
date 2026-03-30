class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] charArr = s.toCharArray();
        for(char ch : charArr) {
            if(ch == '(' ) {
                stack.push(')');
            }else if(ch == '{' ) {
                stack.push('}');
            } else if(ch == '[') {
                stack.push(']');
            } else if(ch == ')' || ch == ']' || ch == '}') {
                if(stack.isEmpty() || stack.peek() != ch) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
