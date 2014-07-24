/*
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

public class Permutations {
    private List<List<Integer>> res = new LinkedList<List<Integer>>();
    private List<Integer> a = new LinkedList<Integer>(); 
    private int length;
    private boolean[] chosen;
    
    public List<List<Integer>> permute(int[] num) {
        length = num.length;
        chosen = new boolean[length];
        for(int i = 0; i < chosen.length; i++) {
            chosen[i] = false;
        }
        pm(num, 0);
        return res;
    }
    
    private void pm(int[] num, int index) {
        if(index == length) {
            res.add(new LinkedList<Integer>(a));
            return;
        }
        
        for(int i = 0; i < length; i++) {
            if(!chosen[i]) {
                chosen[i] = true;
                a.add(num[i]);
                pm(num, index + 1);
                a.remove(index);
                chosen[i] = false;
            }
        }
    }
}
