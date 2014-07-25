/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
*/

public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] A) {
        final int length = A.length;
        if(length < 3) {
            return length;
        }
        
        int index = 0;
        int nlen = 1;
        boolean duplicated = false;
        for(index = 1; index < length; index++) {
            if(A[index] == A[index - 1]) {
                if(!duplicated) {
                    A[nlen++] = A[index];
                }
                duplicated = true;
            } else {
                duplicated = false;
                A[nlen++] = A[index];
            }
        }
        
        return nlen;
    }
}
