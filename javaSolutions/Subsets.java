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
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        res.add(new LinkedList<Integer>());
        final int length = S.length;
        if(length == 0) {
            return res;
        }
        
        Arrays.sort(S);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < length; i++) {
            map.put(S[i], i);
        }
        
        int len1 = 0;
        int len2 = 1;
        List<Integer> list = null;
        for(int size = 0; size < length; size++) {
            for(int i = len1; i < len2; i++) {
                list = res.get(i);
                int start = size == 0 ? -1 : map.get(list.get(size - 1));
                for(start++; start < length; start++) {
                    List<Integer> aset = new LinkedList<Integer>(list);
                    aset.add(S[start]);
                    res.add(aset);
                }
            }
            len1 = len2;
            len2 = res.size();
        }
        
        return res;
    }
}
