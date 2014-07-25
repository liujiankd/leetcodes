/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

public class Combinations {
    List<Integer> cbList = new LinkedList<Integer>();
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    
    public List<List<Integer>> combine(int n, int k) {
        if(k > n) {
            return res;
        }
        cb(n, k, 1);
        return res;
    }
    
    private void cb(int n, int k, int start) {
        if(cbList.size() == k) {
            res.add(new LinkedList(cbList));
            return;
        }
        
        while(start <= n) {
            cbList.add(start++);
            cb(n, k, start);
            cbList.remove(cbList.size() - 1);
        }
    }
}
