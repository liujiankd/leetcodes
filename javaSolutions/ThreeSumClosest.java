/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class ThreeSumClosest {
    // This solution uses O(n^3) time complexity
    public int threeSumClosest1(int[] num, int target) {
        final int length = num.length;
        int result = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < length - 2; i++) {
            for(int j = i + 1; j < length - 1; j++) {
                int s1 = num[i] + num[j];
                for(int k = j + 1; k < length; k++) {
                    if(Math.abs(s1 + num[k] - target) < diff) {
                        result = s1 + num[k];
                        diff = Math.abs(s1 + num[k] - target);
                        if(diff == 0) {
                            return target;
                        }
                    }
                }
            }
        }
        return result;
    }
}
