/*
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        java.util.Map<Character, Integer> map = new java.util.HashMap<Character, Integer>();
		int max = 0;
		int cnt = 0;
		int start = 0;
		final int length = s.length();
		for(int i = 0; i < length; i++) {
			char ch = s.charAt(i);
			if(map.containsKey(ch)) {
				int index = map.get(ch);
				if(index >= start) {
    				cnt = i - index - 1;
    				start = index + 1;
				}
			}
			map.put(ch, i);
			max = Math.max(max, ++cnt);
		}
		return max;
    }
}
