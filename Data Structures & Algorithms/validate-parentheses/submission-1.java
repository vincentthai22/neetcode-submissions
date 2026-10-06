class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for(char c: s.toCharArray()) {
            if(isPop(c)) {
               if(stack.isEmpty() || !isMatching(stack.pop(), c)) {
                 return false;
               }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatching(char left, char right) {
        switch(right) {
            case '}': return left == '{';
            case ']': return left == '[';
            case ')': return left == '(';
            default: return false;
        }
    }

    private boolean isPop(char c) {
        return c == ']' || c == '}' || c == ')';
    }

    private boolean isPush(char c) {
        return c == '[' || c == '{' || c == '(';
    }
}
