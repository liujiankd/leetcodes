/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/

/* TLE if using dfs
   for every round, find the first index in which index + A[index] >= ender, then update ender to this index
   clearly ender is initially A.length - 1.
   This is a greedy algorithm
*/
public class JumpGame2 {
    public int jump(int[] A) {
        int result = 0;
        int start = 0;
        int ender = A.length - 1;
        while(ender > 0) {
            for(int i = 0; i < ender; i++) {
                if(A[i] + i >= ender) {
                    ender = i;
                    result++;
                }
            }
        }
        return result;
    }
}
