/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

public class LetterCombinationsOfAPhoneNumber {
    private Map<Character, String> map;
    private List<String> res;
    private StringBuffer sb;
    private int length;
    private String digit;
    
    private void initMap() {
        map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    
    public List<String> letterCombinations(String digits) {
        res = new LinkedList<String>();
        length = digits.length();
        initMap();
        digit = digits;
        sb = new StringBuffer(length);
        combine(0);
        return res;
    }
    
    private void combine(int index) {
        if(index == length) {
            res.add(new String(sb));
            return;
        }
        String s = map.get(digit.charAt(index));
        for(int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            combine(index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
