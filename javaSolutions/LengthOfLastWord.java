/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int i = s.length() - 1;
        for(; i > -1; i--) {
            if(s.charAt(i) != ' ') {
                do {
                    len++;
                    i--;
                } while(i > -1 && s.charAt(i) != ' ');
                return len;
            }
        }
        return len;
    }

    // The solution bellow costs a little longer
    public int lengthOfLastWord2(String s) {
        String[] words = s.split(" ");
        int len = 0;
        for(int i = words.length - 1; i > -1; i--) {
            if(!words[i].equals("")) {
                len = words[i].length();
                break;
            }
        }
        return len;
    }
} 
