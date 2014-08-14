/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
*/

public class N-Queens2 {
    private int total;
    private int num;
    private boolean[] column;
    private boolean[] mainDiagonal;
    private boolean[] viceDiagonal;
    
    public int totalNQueens(int n) {
        total = 0;
        if(n > 0) {
            num = n;
            column = new boolean[num];
            mainDiagonal = new boolean[2 * num];
            viceDiagonal = new boolean[2 * num];
            solve(0);
        }
        return total;
    }
    
    private void solve(int line) {
        if(line == num) {
            total++;
            return;
        }
        
        for(int col = 0; col < num; col++) {
            if(!column[col] && !mainDiagonal[col - line + num] && !viceDiagonal[col + line]) {
                column[col] = true;
                mainDiagonal[col - line + num] = true;
                viceDiagonal[col + line] = true;
                solve(line + 1);
                column[col] = false;
                mainDiagonal[col - line + num] = false;
                viceDiagonal[col + line] = false;
            }
        }
    }
}
