/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] array = new int[n][n];
        int rlow = 0;
        int clow = 0;
        int rhigh = n;
        int chigh = n;
        int count = n * n;
        int cnt = 0;
        while(cnt < count) {
            int row = rlow;
            int col = clow;
            while(col < chigh) {
                array[row][col] = ++cnt;
                if(col + 1 == chigh) {
                    break;
                }
                col++;
            }
            if(cnt == count){
                break;
            }
            row++;
            while(row < rhigh) {
                array[row][col] = ++cnt;
                if(row + 1 == rhigh) {
                    break;
                }
                row++;
            }
            if(cnt == count){
                break;
            }
            col--;
            while(col >= clow) {
                array[row][col] = ++cnt;
                if(col == clow) {
                    break;
                }
                col--;
            }
            if(cnt == count){
                break;
            }
            row--;
            while(row > rlow) {
                array[row][col] = ++cnt;
                row--;
            }
            rlow++;
            rhigh--;
            clow++;
            chigh--;
        }
        
        return array;
    }
}
