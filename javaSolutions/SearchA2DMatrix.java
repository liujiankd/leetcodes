/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows == 0) {
            return false;
        }
        
        int cols = matrix[0].length;
        int low = 0;
        int high = rows - 1;
        int mid = 0;
        int value = 0;
        // find the row where the target value might in
        while(low < high) {
            mid = (low + high) / 2;
            value = matrix[mid][0];
	    // found it
            if(target == value) {
                return true;
            }
	    // must in previous
            if(target < value) {
                high = mid - 1;
            } else {
                // in this row
                if(target <= matrix[mid][cols - 1]) {
                    low = mid;
                    break;
                } else { // behind this row
                    low = mid + 1;
                }
            }
        }
        
	// no row matches
        if(low > high) {
            return false;
        }
        
        int r = low;
        low = 0;
        high = cols - 1;
	// BS
        while(low <= high) {
            mid = (low + high) / 2;
            value = matrix[r][mid];
            if(value == target) {
                return true;
            }
            if(value < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
