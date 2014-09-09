/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6]
*/

public class CombinationSum2 {
    private List<List<Integer>> result;
    private Set<List<Integer>> set;
    private int[] array;
    private int tgt;
    private List<Integer> list;
    
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        result = new LinkedList<List<Integer>>();
        if(num.length > 0) {
            array = num;
            Arrays.sort(array);
            tgt = target;
            list = new LinkedList<Integer>();
            set = new HashSet<List<Integer>>();
            findSum(0, 0);
            for(List<Integer> tmp : set) {
                result.add(tmp);
            }
        }
        return result;
    }
    
    private void findSum(int sum, int start) {
        if(sum == tgt) {
            set.add(new LinkedList<Integer>(list));
            return;
        }
        
        for(int i = start; i < array.length; i++) {
            if(sum + array[i] <= tgt) {
                list.add(array[i]);
                findSum(sum + array[i], i + 1);
                list.remove(list.size() - 1);
            } else {
                break;
            }
        }
    }
}
