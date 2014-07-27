/*
Determine whether an integer is a palindrome. Do this without extra space.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
*/

public class PalindromeNumber {
    // Reverse solution
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        
        int tmp = x;
        long rev = 0;
        while(tmp != 0) {
            rev = rev * 10 + tmp % 10;
            tmp /= 10;
        }
        
        if(rev == x) {
            return true;
        } else {
            return false;
        }
    }
}
