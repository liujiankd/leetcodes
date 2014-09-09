/*

Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3]

*/

public class CombinationSum {
    private List<List<Integer>> result;
    private int[] array;
    private int tgt;
    private List<Integer> list;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new LinkedList<List<Integer>>();
        if(candidates.length > 0) {
            array = candidates;
            tgt = target;
            Arrays.sort(array);
            list = new LinkedList<Integer>();
            findSum(0, 0);
        }
        return result;
    }
    
    private void findSum(int sum, int start) {
        if(sum == tgt) {
            result.add(new LinkedList<Integer>(list));
            return;
        }
        
        for(int i = start; i < array.length; i++) {
            if(array[i] + sum <= tgt) {
                list.add(array[i]);
                findSum(array[i] + sum, i);
                list.remove(list.size() - 1);
            }
        }
    }
}
