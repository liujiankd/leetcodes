/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

import java.util.Arrays;

public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        final int length = A.length;
        int[] res = new int[]{-1, -1};
        if(length == 0 || target < A[0] || A[length - 1] < target) {
            return res;
        }
        
        int mid = Arrays.binarySearch(A, target);
        if(mid < 0) {
            return res;
        }
        
        res[0] = search(A, target, 0, mid, 0);
        res[1] = search(A, target, mid, length - 1, 1);
        return res;
    }
    
    private int search(int[] A, int target, int low, int high, int type) {
        int mid = 0;
        while(low <= high) {
            mid = (low + high) >> 1;
            if(target < A[mid]) {
                high = mid - 1;
            } else if(A[mid] < target) {
                low = mid + 1;
            } else {
                if(type == 0) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        if(type == 0) {
            return low;
        } else {
            return high;
        }
    }
}
