/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if(rows == 0 || cols == 0) {
            return 0;
        }
        
        int[][] array = new int[rows][cols];
        int r;
        int c;
        array[0][0] = grid[0][0];
        for(r = 1; r < rows; r++) {
            array[r][0] = grid[r][0] + array[r - 1][0];
        }
        for(c = 1; c < cols; c++) {
            array[0][c] = grid[0][c] + array[0][c - 1];
        }
        
        for(r = 1; r < rows; r++) {
            for(c = 1; c < cols; c++) {
                array[r][c] = Math.min(array[r - 1][c], array[r][c - 1]) + grid[r][c];
            }
        }
        
        return array[rows - 1][cols - 1];
    }
}
/*
The solution above (DP) uses O(M * N) space.
We can use "jianzhi" recursively to get the right answer
The next solution uses "jianzhi", but didn't pass the leetcode oj
The oj gives WA when given case '[[1]]', output 0, expect 1
But when given case '[[1]]' in Eclipse, the codes actually returns 1 in my PC.
OH, that's really weird.
    
    private static int minSum = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        if(grid.length == 0) {
            return 0;
        }
        pathSum(grid, 0, 0, 0);
        return minSum;
    }
    
    private void pathSum(int[][] grid, int x, int y, int currentSum) {
        currentSum += grid[x][y];
        if(currentSum >= minSum) {
            return;
        }
        int xlen = grid.length;
        int ylen = grid[0].length;
        if(x == xlen - 1 && y == ylen - 1) {
            minSum = currentSum < minSum ? currentSum : minSum;
            return;
        }
        if(x < xlen - 1) {
            pathSum(grid, x + 1, y, currentSum);   
        }
        if(y < ylen - 1) {
            pathSum(grid, x, y + 1, currentSum);
        }
    }
*/
