/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/

public class JumpGame {
    public boolean canJump(int[] A) {
        final int length = A.length;
        if(length == 0) {
            return false;
        }
        if(length == 1) {
            return true;
        }
        int count = 0;
        int i = length - 1;
        if(A[i] == 0) {
            count++;
            while(--i >= 0 && A[i] == 0) {
                count++;
            }
            if(i < 0) {
                return false;
            } else if(A[i] >= count) {
                    count = 0;
            }
        }
        for(; i >= 0; i--) {
            if(A[i] == 0) {
                count++;
            } else {
                if(A[i] > count) {
                    count = 0;
                } else {
                    count++;
                }
            }
        }
        
        return count == 0 ? true : false;
    }
}
