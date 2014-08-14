/*
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
import java.util.*;

public class Subsets2 {
    private List<List<Integer>> res;
    private List<Integer> tmp;
    private int[] array;
    private int length;
    
    public List<List<Integer>> subsetsWithDup(int[] num) {
        res = new LinkedList<List<Integer>>();
        tmp = new LinkedList<Integer>();
        array = num;
        length = array.length;
        Arrays.sort(array);
        subSets(0);
        return res;
    }
    
    private void subSets(int index) {
        res.add(new LinkedList<Integer>(tmp));
        for(int i = index; i < length; i++) {
            if(i != index && array[i] == array[i - 1]) {
                continue;
            }
            tmp.add(array[i]);
            subSets(i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
