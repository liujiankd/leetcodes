/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/

public class Permutations2 {
    private List<List<Integer>> res;
    private List<Integer> per;
    private int[] array;
    private int length;
    private boolean[] chosen;
    
    public List<List<Integer>> permuteUnique(int[] num) {
        res = new LinkedList<List<Integer>>();
        length = num.length;
        if(length == 0) {
            return res;
        }
        
        array = num;
        per = new ArrayList<Integer>(length);
        chosen = new boolean[length];
        Arrays.fill(chosen, false);
        Arrays.sort(num);
        permute(0);
        return res;
    }
    
    private void permute(int cur) {
        if(cur == length) {
            res.add(new ArrayList<Integer>(per));
            return;
        }
        
        int lastIndex = -1;
        for(int i = 0; i < length; i++) {
            if(!chosen[i] && (lastIndex == -1 || array[i] != array[lastIndex])) {
                lastIndex = i;
                chosen[i] = true;
                per.add(array[i]);
                permute(cur + 1);
                per.remove(per.size() - 1);
                chosen[i] = false;
            }
        }
    }
}
