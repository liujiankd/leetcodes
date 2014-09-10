/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/

public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(num.length < 3) {
            return result;
        }
        
        Arrays.sort(num); 
        for(int i = 0; i < num.length - 3; i++) {
            if(i == 0 || num[i] != num[i - 1]) {
                for(int j = i + 1; j < num.length - 2; j++) {
                    if(j == i + 1 || num[j] != num[j - 1]) {
                        int tgt = target - num[i] - num[j];
                        int start = j + 1;
                        int ender = num.length - 1;
                        while(start < ender) {
                            int sum = num[start] + num[ender];
                            if(sum == tgt) {
                                List<Integer> list = new ArrayList<Integer>(4);
                                list.add(num[i]);
                                list.add(num[j]);
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
                            } else if(sum < tgt) {
                                start++;
                            } else {
                                ender--;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
