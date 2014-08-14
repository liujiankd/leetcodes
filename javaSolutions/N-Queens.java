/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

public class N-Queens {
    private List<String[]> res;
    private int num;
    private boolean[] column;
    private boolean[] mainDiagonal;
    private boolean[] viceDiagonal;
    private int[] queen;
    
    public List<String[]> solveNQueens(int n) {
        num = n;
        res = new LinkedList<String[]>();
        if(num > 0) {
            column = new boolean[num];
            mainDiagonal = new boolean[2 * num];
            viceDiagonal = new boolean[2 * num];
            queen = new int[num];
            solve(0);
        }
        return res;
    }
    
    private void solve(int line) { // currently in line cur
        if(line == num) {
            makeAnswer();
            return;
        }
        
        for(int col = 0; col < num; col++) {
            if(!column[col] && !mainDiagonal[col - line + num] && !viceDiagonal[col + line]) {
                column[col] = true;
                mainDiagonal[col - line + num] = true;
                viceDiagonal[col + line] = true;
                queen[line] = col;
                solve(line + 1);
                column[col] = false;
                mainDiagonal[col - line + num] = false;
                viceDiagonal[col + line] = false;
            }
        }
    }
    
    private void makeAnswer() {
        String[] answer = new String[num];
        for(int i = 0; i < num; i++) {
            StringBuffer sb = new StringBuffer(num);
            int k = 0;
            while(k != queen[i]) {
                sb.append('.');
                k++;
            }
            sb.append('Q');
            k++;
            while(k < num) {
                sb.append('.');
                k++;
            }
            answer[i] = sb.toString();
        }
        res.add(answer);
    }
}
