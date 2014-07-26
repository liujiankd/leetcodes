/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class ValidParentheses {
    public boolean isValid(String s) {
        List<Character> stk = new LinkedList<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        char ch = '(';
        int length = 0;
        for(int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                stk.add(ch);
            } else {
                length = stk.size();
                if(length == 0) {
                    return false;
                } else {
                    if(stk.get(length - 1) != map.get(ch)) {
                        return false;
                    }
                    stk.remove(length - 1);
                }
            }
        }
        if(stk.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
