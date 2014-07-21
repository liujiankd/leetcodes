/* Maximum Subarray
          Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

	  For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
	  the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */

public class MaximumSubarray {
    
    /*
	O(n) solution
    */
    public int maxSubArray(int[] A) {
	int sum = A[0]; // At least one number
	int max = A[0];

	for(int index = 1; index < A.length; index++) {
	    sum = (sum < 0) ? A[index] : sum + A[index];
	    max = (sum > max) ? sum : max;
	}

	return max;
    }
}
