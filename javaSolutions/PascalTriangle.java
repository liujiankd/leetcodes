/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

import java.util.List;
import java.util.LinkedList;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(numRows == 0) {
            return res;
        }
        
        List<Integer> list = new LinkedList<Integer>();
        list.add(1);
        res.add(list);
        List<Integer> tmp = null;
        for(int i = 1; i < numRows; i++) {
            tmp = new LinkedList<Integer>();
            tmp.add(1);
            for(int j = 1; j < list.size(); j++) {
                tmp.add(list.get(j - 1) + list.get(j));
            }
            tmp.add(1);
            res.add(tmp);
            list = tmp;
        }
        
        return res;
    }

}
