/*

*/

public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        final int length = A.length;
        int low = 0;
        int high = length - 1;
        int mid = 0;
        while(low <= high) {
            mid = (low + high) >> 1;
            if(target == A[mid]) {
                break;
            }
            if(A[mid] <= A[high]) {
                if(target < A[mid]) {
                    high = mid - 1;
                } else {
                    if(target <= A[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            } else {
                if(target > A[mid]) {
                    low = mid + 1;
                } else {
                    if(target >= A[low]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        if(low <= high) {
            return mid;
        } else {
            return -1;
        }
    }
}
