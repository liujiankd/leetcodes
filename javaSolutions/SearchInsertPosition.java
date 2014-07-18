/* AC codes. */

public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        int mid;

        // if length == 0, that will be the right position to insert
	while(low < high) {
            mid = (low + high) / 2;
            if(target == A[mid]) { // find the same value, so that's it!
                return mid;
            }
            if(target < A[mid]) { // may be in the left part
                high = mid < high ? mid : mid - 1; // to ensure we will not loop here, ie. input [1, 3], 2
            } else {              // may be in the right part
                low = mid > low ? mid : mid + 1;   // to make sure not loop
            }
        }

	// if low == high, then the position is just around.
        if(low == high) {
            if(target <= A[low]) {
                return low;
            } else {
                return low + 1;
            }
        }

        return low;
    }
}
