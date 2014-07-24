/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int length = height.length;
        if(length < 2) {
            return 0;
        }
        
        int max = 0;
        int low = 0;
        int high = length - 1;
        int tmp = 0;
        do {
            max = Math.max(max, Math.min(height[low], height[high]) * (high - low));
            if(height[low] < height[high]) {
                tmp = height[low++];
                while(low < high && height[low] <= tmp) {
                    low++;
                }
            } else {
                tmp = height[high--];
                while(high > low && height[high] <= tmp) {
                    high--;
                }
            }
        } while(low < high);
        
        return max;
    }
}
