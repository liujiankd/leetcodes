/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
*/

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        if(A.length < 2) {
            return A.length;
        }
        
        int length = 1;
        for(int index = 1; index < A.length; index++) {
            if(A[index] != A[index - 1]) {
                A[length++] = A[index];
            }
        }
        return length;
    }
}
