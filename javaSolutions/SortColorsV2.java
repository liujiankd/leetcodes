/*
 The first solution is a two-pass algorithm using counting sort.
 Here is an one-pass algorithm using only constant space.
*/

public class SortColorsV2 {
    public void sortColors(int[] A) {
        int end = A.length - 1;
        int ptr = 0; // left part of ptr are all 0
        for(int i = 0; i <= end; i++) {
            if(A[i] == 0) {
                swap(A, i, ptr++);
            } else if(A[i] == 2) {
                while(i < end && A[end] == 2) { // from right to left, find the first '0' or '1'
                    end--;
                }
                if(i == end) { // overlapped, just break to finish!
                    break;
                }
                swap(A, i, end); // found '0' or '1', just swap with A[i] to put '2' at tail
                if(A[i] == 0) {  // it's a '0', just swap with A[ptr]
                    swap(A, i, ptr++);
                }
		// if it is a '1', then ptr just points to it.
            }
        }
    }
    
    private void swap(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }

}
