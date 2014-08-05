/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/

public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        final int length = A.length;
        for(int i = 0; i < length; i++) {
            int value = A[i];
            while(value >= 1 && value <= length && A[value - 1] != value) {
                int tmp = A[value - 1];
                A[value - 1] = value;
                value = tmp;
            }
        }
        
        for(int i = 0; i < length; i++) {
            if(A[i] != i + 1) {
                return i + 1;
            }
        }
        return length + 1;
    }
}
