/*

*/

public class SearchInRotatedSortedArray2 {
    public boolean search(int[] A, int target) {
        final int length = A.length;
        int low = 0;
        int high = length - 1;
        int mid = 0;
        while(low <= high) {
            mid = (low + high) >> 1;
            if(target == A[mid] || target == A[low] || target == A[high]) {
                return true;
            }
            
            if(A[low] != A[mid] && A[mid] != A[high]) {
                if(A[mid] < A[high]) {
                    if(target < A[mid] || target > A[high]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    if(target > A[mid] || target < A[low]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            } else if(A[low] == A[mid] && A[mid] != A[high]) {
                low = mid + 1;
            } else if(A[low] != A[mid] && A[mid] == A[high]) {
                high = mid - 1;
            } else {
                low++;
                high--;
            }
        }
        return false;
    }
}
