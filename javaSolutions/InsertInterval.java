/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
*/

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<Interval>();
        final int length = intervals.size();
        int start = newInterval.start;
        int end = newInterval.end;
        boolean flag = false;
        for(int i = 0; i < length; i++) {
            Interval val = intervals.get(i);
            
            // [5, 7] to [8, 12]
            if(end < val.start) {
                res.add(new Interval(start, end));
                while(i < length) {
                    res.add(intervals.get(i++));
                }
                flag = true;
                break;
            }
            
            //[6, 9] or [9, 11] to [8, 12]
            if(end <= val.end) {
                res.add(new Interval(Math.min(start, val.start), val.end));
                i++;
                while(i < length) {
                    res.add(intervals.get(i++));
                }
                flag = true;
                break;
            }
            
            // here, end is greater than val.end
            // [6, 14] to [8, 12]
            if(start <= val.start) {
                continue;
            }
            
            // here, start is greater than val.start
            // [10, 13] to [8, 12]
            if(start <= val.end) {
                start = val.start;
                continue;
            }
            
            // [13, 15] to [8, 12]
            if(val.end < start) {
                res.add(val);
            }
            
        }
        
        if(!flag) {
            res.add(new Interval(start, end));
        }
        return res;
    }
}
