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

public class Subsets2 {
    private List<List<Integer>> res;
    private List<Integer> tmp;
    
    public List<List<Integer>> subsetsWithDup(int[] num) {
        res = new LinkedList<List<Integer>>();
        tmp = new LinkedList<Integer>();
        res.add(tmp);
        if(num.length == 0) {
            return res;
        }
        
        Arrays.sort(num);
        subSets(num, 0);
        return res;
    }
    
    private void subSets(int[] num, int index) {
        for(int i = index; i < num.length; i++) {
            if(i != index && num[i] == num[i - 1]) {
                continue;
            }
            tmp.add(num[i]);
            List<Integer> a = new LinkedList<Integer>(tmp);
            res.add(a);
            subSets(num, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
