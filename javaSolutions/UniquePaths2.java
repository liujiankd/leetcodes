/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/

// Can walk down or right

public class UniquePaths {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
	// start point or finish point has obstacles
        if(obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1) {
            return 0;
        }
        int[] a = new int[cols + 1];
        a[cols] = 1; // suppose the finish point can be reached
        int r;
        int c;
        for(r = rows - 1; r > -1; r--) {
            for(c = cols - 1; c > -1; c--) {
		// if has obstacle, can not walk through this point
		// else plus the previous paths num.
                a[c] = (obstacleGrid[r][c] == 1) ? 0 : a[c] + a[c + 1];
            }
	    // outside of the array
            a[cols] = 0;
        }
        return a[0];
    }
}
