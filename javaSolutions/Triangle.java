/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        final int length = triangle.size();
        if(length == 0) {
            return 0;
        }
        
        int[] cost = new int[length + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[1] = triangle.get(0).get(0);
        for(int i = 1; i < length; i++) {
            List<Integer> tmp = triangle.get(i);
            for(int j = tmp.size(); j > 0; j--) {
                cost[j] = Math.min(cost[j - 1], cost[j]) + tmp.get(j - 1);
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= length; i++) {
            min = Math.min(min, cost[i]);
        }
        return min;
    }
}
