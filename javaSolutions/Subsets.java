/*
Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
import java.util.*;

public class Subsets {
    private List<List<Integer>> res;
    private int[] a;
    private int length;
    private List<Integer> tmp;
    
    public List<List<Integer>> subsets(int[] S) {
        a = S;
        length = a.length;
        Arrays.sort(a);
        res = new LinkedList<List<Integer>>();
        tmp = new LinkedList<Integer>();
        makeSubSets(0);
        return res;
    }
    
    private void makeSubSets(int cur) {
        res.add(new LinkedList<Integer>(tmp));
        for(int i = cur; i < length; i++) {
            tmp.add(a[i]);
            makeSubSets(i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
