/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?
*/

// (m,n) = (m-1,n) + (m,n-1) ; if(m > 1 && n > 1)
// else (m,n) = 1;

public class UniquePaths {
    // O(m * n) space, O(m * n) time
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) {
            return 1;
        }
        
        int[][] array = new int[m][n];
        int  row = 0;
        int  col = 0;
        for(row = m - 1; row > -1; row--) {
            array[row][n - 1] = 1;
        }
        for(col = n - 1; col > -1; col--) {
            array[m - 1][col] = 1;
        }
        
        for(row = m - 2; row > -1; row--) {
            for(col = n - 2; col > -1; col--) {
                array[row][col] = array[row + 1][col] + array[row][col + 1];
            }
        }
        
        return array[0][0];
    }

    // use O(n) space
    public int uniquePaths1(int m, int n) {
        if(m == 1 || n == 1) {
            return 1;
        }
        int[] cols = new int[n];
        int row;
        int col;
        java.util.Arrays.fill(cols, 1);
        for(row = m - 2; row > -1; row--) {
            for(col = n - 2; col > -1; col--) {
                cols[col] += cols[col + 1];
            }
        }
        return cols[0];
    }
}
