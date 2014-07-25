/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/

public class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        java.util.List<Integer> res = new java.util.LinkedList<Integer>();
        int[] row = new int[rowIndex + 1];
        java.util.Arrays.fill(row, 0);
        row[0] = 1;
        int rnd = 0;
        int i = 0;
        for(rnd = 1; rnd <= rowIndex; rnd++) {
            for(i = rnd; i >= 1; i--) {
                row[i] += row[i - 1];
            }
        }
        for(i = 0; i <= rowIndex; i++) {
            res.add(row[i]);
        }
        return res;
    }
}
