/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/

public class CountAndSay {
    public String countAndSay(int n) {
        if(n < 1) {
            return "";
        }
        
        String num = "1";
        for(int i = 1; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            int length = num.length();
            for(int j = 0; j < length; j++) {
                char ch = num.charAt(j);
                int count = 1;
                while(j + 1 < length && num.charAt(j + 1) == ch) {
                    j++;
                    count++;
                }
                sb.append(count);
                sb.append(ch);
            }
            num = sb.toString();
        }
        
        return num;
    }
}
