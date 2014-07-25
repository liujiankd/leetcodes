/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int i = 0;
        for(i = 0; i < length; i++) {
            if(digits[i] != 9) {
                break;
            }
        }
        
        int[] num = null;
        if(i == length) {
            num = new int[length + 1];
            java.util.Arrays.fill(num, 0);
            num[0] = 1;
        } else {
            num = new int[length];
            int tmp = 0;
            int carry = 1;
            for(i = length - 1; i > -1; i--) {
                tmp = digits[i] + carry;
                num[i] = tmp % 10;
                carry = tmp / 10;
            }
        }
        
        return num;
    }
}
