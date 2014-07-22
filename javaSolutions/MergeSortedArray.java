/*
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
*/

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int pos = m + n - 1;
        int pa = m - 1;
        int pb = n - 1;
        while(pa > -1 || pb > -1) {
            if(pb == -1) {
                break;
            }
            
            while(pa > -1 && A[pa] >= B[pb]) {
                A[pos--] = A[pa--];
            }
            
            if(pa == -1) {
                while(pb > -1) {
                    A[pos--] = B[pb--];
                }
                break;
            }
            
            while(pb > -1 && B[pb] >= A[pa]) {
                A[pos--] = B[pb--];
            }
        }
    }
}
