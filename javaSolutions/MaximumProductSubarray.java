/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

public class MaximumProductSubarray {
    private int[] array;
    private int len;
    
    public int maxProduct(int[] A) {
        if(A.length == 1) {
            return A[0];
        }
        
        // at least two numbers, so the maximum product is at least 0
        array = A;
        len = A.length;
        int product = Integer.MIN_VALUE;
        int start = 0;
        boolean hasZero = false;
        while(start < len) {
            start = getNoneZeroIndex(start);
            if(start == len) {
                break;
            }
            int ender = getNextZeroIndex(start + 1); // [start, ender), at least one number in this interval
            
            if(ender < len) {
                hasZero = true;
            }
            
            if(ender - start == 1) {
                product = array[start] > product ? array[start] : product;
                start = ender + 1;
                continue;
            }
            
            int firstPart = 1; // the product before the first negative number in this interval
            int i = start;
            while(i < ender && array[i] > 0) {
                firstPart *= array[i];
                i++;
            }
            if(i == ender) { // no negative number
                product = firstPart > product ? firstPart : product;
                start = ender + 1;
                continue;
            }
            
            // now i points to the first negative number
            int firstNeg = array[i];
            
            // now compute the lastPart of this interval
            int lastPart = 1;
            int j = ender - 1;
            while(j > i && array[j] > 0) {
                lastPart *= array[j];
                j--;
            }
            if(j == i) { // there is only one negative number in this interval
                int max = firstPart > lastPart ? firstPart : lastPart;
                product = max > product ? max : product;
                start = ender + 1;
                continue;
            }
            
            // now j points to the last negative number and it is not the number in index i
            int lastNeg = array[j];
            
            // now compute the middle part of this interval
            int midPart = 1;
            for(i++; i < j; i++) {
                midPart *= array[i];
            }
            
            if(midPart > 0) { // there is no negative number or has even
                int total = firstPart * firstNeg * midPart * lastNeg * lastPart;
                product = total > product ? total : product;
            } else { // odd
                int left = firstPart * firstNeg * midPart;
                int right = midPart * lastNeg * lastPart;
                int max = left > right ? left : right;
                product = max > product ? max : product;
            }
            start = ender + 1;
        }
        
        return (product < 0 && hasZero) ? 0 : product;
    }
    
    private int getNoneZeroIndex(int index) {
        while(index < len && array[index] == 0) {
            index++;
        }
        return index;
    }
    
    private int getNextZeroIndex(int index) {
        while(index < len && array[index] != 0) {
            index++;
        }
        return index;
    }
}
