/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        java.util.Deque<Integer> stack = new java.util.ArrayDeque<Integer>();
        final int length = s.length();
        boolean[] matched = new boolean[length];
        for(int i = 0; i < length; i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if(stack.size() > 0) {
                    int index = stack.pop();
                    matched[index] = true;
                    matched[i] = true;
                }
            }
        }
        
        
        int max = 0;
        int cnt = 0;
        for(int i = 0; i < length; i++) {
            if(matched[i]) {
                cnt++;
            } else {
                max = Math.max(max, cnt);
                cnt = 0;
            }
        }
        
        return Math.max(max, cnt);
    }
}
