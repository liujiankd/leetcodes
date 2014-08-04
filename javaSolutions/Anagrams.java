/*
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
*/

public class Anagrams {
    public List<String> anagrams(String[] strs) {
        List<String> res = new LinkedList<String>();
        final int length = strs.length;
        if(length < 2) {
            return res;
        }
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < length; i++) {
            char[] a = strs[i].toCharArray();
            Arrays.sort(a);
            String s = String.valueOf(a); // char array should be transformed to be string, or map.containsKey(char array) will always return false
            if(map.containsKey(s)) {
                int index = map.get(s);
                if(!set.contains(index)) {
                    res.add(strs[index]);
                    set.add(index);
                }
                res.add(strs[i]);
                set.add(i);
            } else {
                map.put(s, i);
            }
        }
        return res;
    }
}
