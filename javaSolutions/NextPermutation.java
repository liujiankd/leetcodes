/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

public class NextPermutation {
    public void nextPermutation(int[] num) {
        final int length = num.length;
        if(length < 2) {
            return;
        }
        
        int i = length - 2;
        while(i > -1 && num[i] >= num[i + 1]) {
            i--;
        }
        
        for(int j = i + 1, k = length - 1; j < k; j++, k--) {
            swap(num, j, k);    
        }
        
        if(i > -1) {
            int index = findGreater(num, i);
            if(index < length) {
                swap(num, i, index);
            }
        }
    }
    
    private void swap(int[] num, int j, int k) {
        int tmp = num[j];
        num[j] = num[k];
        num[k] = tmp;
    }
    
    private int findGreater(int[] num, int target) {
        int start = target + 1;
        while(start < num.length && num[start] <= num[target]) {
            start++;
        }
        return start;
    }
}
