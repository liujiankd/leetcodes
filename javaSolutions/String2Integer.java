/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
*/

public class String2Integer {
    public int atoi(String str) {
        final int length = str.length();
        if(length == 0) {
            return 0;
        }
        
        int i = 0;
        char ch = 0;
        while(i < length) {
           ch = str.charAt(i); 
           if(ch != ' ') {
               break;
           }
           i++;
        }
        
        boolean negative = false;
        if(ch == '-') {
            negative = true;
            i++;
        } else if(ch == '+') {
            i++;
        } else if(ch < '0' || ch > '9') {
            return 0;
        }
        
        long num = 0;
        while(i < length) {
            ch = str.charAt(i);
            i++;
            if(ch < '0' || ch > '9') {
                break;
            }
            num = num * 10 + ch - '0';
        }

        if(negative) {
            num = -num;
            if(num <= Integer.MIN_VALUE) {
                num = Integer.MIN_VALUE;
            }
        } else {
            if(num >= Integer.MAX_VALUE) {
                num = Integer.MAX_VALUE;
            }
        }
        return (int)num;
    }
}
