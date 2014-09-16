/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/

public class PalindromePartitioning {
    private List<List<String>> result;
    private char[] chs;
    private boolean[][] isp;
    private List<String> list;
    
    public List<List<String>> partition(String s) {
        result = new LinkedList<List<String>>();
        chs = s.toCharArray();
        if(chs.length == 0) {
            return result;
        }
        
        isp = new boolean[chs.length][chs.length];
        for(int i = 0; i < chs.length; i++) {
            isp[i][i] = true;
            for(int j = 1; j < chs.length; j++) {
                isp[i][j] = isPalindrome(i, j) ? true : false;
            }
        }
        
        list = new LinkedList<String>();
        judge(0);
        return result;
    }
    
    private void judge(int index) {
        if(index == chs.length) {
            result.add(new LinkedList<String>(list));
            return;
        }
        
        for(int i = index; i < chs.length; i++) {
            if(isp[index][i]) {
                list.add(getStr(index, i));
                judge(i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private String getStr(int start, int ender) {
        StringBuilder sb = new StringBuilder();
        while(start <= ender) {
            sb.append(chs[start++]);
        }
        return sb.toString();
    }
    
    private boolean isPalindrome(int start, int ender) {
        while(start < ender) {
            if(chs[start++] != chs[ender--]) {
                return false;
            }
        }
        return true;
    }
}
