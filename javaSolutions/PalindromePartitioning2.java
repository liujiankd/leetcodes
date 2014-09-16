/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/

public class PalindromePartitioning2 {
    public int minCut(String s) {
        final int len = s.length();
        boolean[][] isp = new boolean[len][len];
        for(boolean[] b : isp) {
            Arrays.fill(b, false);
        }
        int[] dp = new int[len + 1];
        for(int i = 0; i <= len; i++) {
            dp[i] = len - i;
        }
        
        for(int i = len - 1; i > -1; i--) {
            int ch = s.charAt(i);
            for(int j = i; j < len; j++) {
                if(s.charAt(j) == ch && (j - i < 2 || isp[i + 1][j - 1])) {
                    isp[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0] - 1;
    }
}
