/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(num.length < 3) {
            return result;
        }
        
        Arrays.sort(num);
        for(int i = 0; i < num.length - 2; i++) {
            if(i == 0 || num[i] != num[i - 1]) {
                int target = 0 - num[i];
                int start = i + 1;
                int ender = num.length - 1;
                while(start < ender) {
                    int sum = num[start] + num[ender];
                    if(sum == target) {
                        List<Integer> list = new ArrayList<Integer>(3);
                        list.add(num[i]);
                        list.add(num[start]);
                        list.add(num[ender]);
                        result.add(list);
                        start++;
                        ender--;
                        while(start < ender && num[start] == num[start - 1]) {
                            start++;
                        }
                        while(ender > start && num[ender] == num[ender + 1]) {
                            ender--;
                        }
                    } else if(sum < target) {
                        start++;
                    } else {
                        ender--;
                    }
                }
            }
        }
        return result;
    }
}
