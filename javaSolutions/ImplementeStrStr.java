/*
Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
*/

public class ImplementStrStr {
    public String strStr(String haystack, String needle) {
        final int lenHay = haystack.length();
        final int lenNeedle = needle.length();
        if(lenHay < lenNeedle) {
            return null;
        } else if(lenNeedle == 0) {
            return haystack;
        }
        
        char ch = needle.charAt(0);
        for(int i = 0; i <= lenHay - lenNeedle; i++) {
            if(haystack.charAt(i) == ch) {
                boolean flag = true;
                for(int j = 1; j < lenNeedle; j++) {
                    if(needle.charAt(j) != haystack.charAt(i + j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    return haystack.substring(i);
                }
            }
        }
        return null;
    }
}
