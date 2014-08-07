/*
Write a function to find the longest common prefix string amongst an array of strings.
*/

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        final int length = strs.length;
        if(length == 0) {
            return "";
        } else if(length == 1) {
            return strs[0];
        }
        
        int pos = 0;
        while(true) {
            if(pos >= strs[0].length()) {
                break;
            }
            char ch = strs[0].charAt(pos);
            int i = 1;
            for(; i < length; i++) {
                if(pos >= strs[i].length() || strs[i].charAt(pos) != ch) {
                    break;
                }
            }
            
            if(i < length) {
                break;
            }
            pos++;
        }
        
        return strs[0].substring(0, pos);
    }
}
