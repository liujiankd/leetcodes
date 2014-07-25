/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
*/

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) {
            return;
        }
        
        int cols = matrix[0].length;
        boolean[] m = new boolean[rows];
        boolean[] n = new boolean[cols];
        java.util.Arrays.fill(m, false);
        java.util.Arrays.fill(n, false);
        int r = 0;
        int c = 0;
        for(r = 0; r < rows; r++) {
            for(c = 0; c < cols; c++) {
                if(matrix[r][c] == 0) {
                    m[r] = true;
                    n[c] = true;
                }
            }
        }
        
        for(r = 0; r < rows; r++) {
            if(m[r]) {
                java.util.Arrays.fill(matrix[r], 0);
            }
        }
        
        for(c = 0; c < cols; c++) {
            if(n[c]) {
                for(r = 0; r < rows; r++) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
}
