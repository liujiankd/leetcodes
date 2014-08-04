/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int start = 0;
        int ender = s.length() - 1;
        while(start < ender) {
            while(start < ender && !isAlpha(s.charAt(start)) && !isNumeric(s.charAt(start))) {
                start++;
            }
            while(start < ender && !isAlpha(s.charAt(ender)) && !isNumeric(s.charAt(ender))) {
                ender--;
            }
            
            if(start >= ender) {
                break;
            }
            
            if(isNumeric(s.charAt(start))) {
                if(!isNumeric(s.charAt(ender)) || s.charAt(start) != s.charAt(ender)) {
                    return false;
                }
            } else {
                if(!isAlpha(s.charAt(ender))) {
                    return false;
                }
                if(getAlpha(s.charAt(start)) != getAlpha(s.charAt(ender))) {
                    return false;
                }
            }
            start++;
            ender--;
        }
        
        return true;
    }
    
    private int getAlpha(char ch) {
        return ch >= 'a' ? ch - 'a' : ch - 'A';
    }
    
    private boolean isAlpha(char ch) {
        if(ch >= 'A' && ch <= 'Z') {
            return true;
        }
        if(ch >= 'a' && ch <= 'z') {
            return true;
        }
        return false;
    }
    
    private boolean isNumeric(char ch) {
        if(ch >= '0' && ch <= '9') {
            return true;
        } else {
            return false;
        }
    }
}
