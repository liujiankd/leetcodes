/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        java.util.List<Integer> res = new java.util.LinkedList<Integer>();
        final int rows = matrix.length;
        if(rows == 0) {
            return res;
        }
        
        final int cols = matrix[0].length;
        final int total = rows * cols;
        int rlow = 0;
        int rhigh = rows;
        int clow = 0;
        int chigh = cols;
        int row = rlow;
        int col = clow;
        int cnt = 0;
        while(cnt < total) {
            row = rlow;
            col = clow;
            while(col < chigh) {
                res.add(matrix[row][col]);
                cnt++;
                if(col + 1 == chigh) {
                    break;
                }
                col++;
            }
            if(cnt == total) {
                break;
            }
            row++;
            while(row < rhigh) {
                res.add(matrix[row][col]);
                cnt++;
                if(row + 1 == rhigh) {
                    break;
                }
                row++;
            }
            if(cnt == total) {
                break;
            }
            col--;
            while(col >= clow) {
                res.add(matrix[row][col]);
                cnt++;
                if(col == clow) {
                    break;
                }
                col--;
            }
            if(cnt == total) {
                break;
            }
            row--;
            while(row > rlow) {
                res.add(matrix[row][col]);
                cnt++;
                row--;
            }
            rlow++;
            rhigh--;
            clow++;
            chigh--;
        }
        return res;
    }
}
