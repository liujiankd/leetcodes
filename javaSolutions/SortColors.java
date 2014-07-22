/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
*/

public class SortColors {
    public void sortColors(int[] A) {
        int red = 0;
        int white = 0;
        int blue = 0;
        int i;
        for(i = 0; i < A.length; i++) {
            switch(A[i]) {
                case 0: red++; break;
                case 1: white++; break;
                case 2: blue++; break;
            }
        }
        
        i = 0;
        while(red-- > 0) {
            A[i++] = 0;
        }
        while(white-- > 0) {
            A[i++] = 1;
        }
        while(blue-- > 0) {
            A[i++] = 2;
        }
    }
}

