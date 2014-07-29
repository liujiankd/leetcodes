/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
        for(int n : num) {
            set.add(n);
        }
        
        int max = 0;
        int count = 0;
        for(int n : num) {
            if(!set.contains(n)) {
                continue;
            }
            
            count = 1;
            set.remove(n);
            int tmp = n;
            while(set.contains(--tmp)) {
                count++;
                set.remove(tmp);
            }
            
            tmp = n;
            while(set.contains(++tmp)) {
                count++;
                set.remove(tmp);
            }
            
            max = (count > max) ? count : max;
        }
        
        return max;
    }
}
