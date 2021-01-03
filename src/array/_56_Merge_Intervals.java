package array;

import java.util.ArrayList;
import java.util.List;

public class _56_Merge_Intervals {

    private static class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static List<Interval> mergeIntervals(int[] timeSeries, int duration) {

        List<Interval> intervals = new ArrayList<>();
        for(int i : timeSeries) {
            intervals.add(new Interval(i-1, i-1+duration));
        }

        intervals.sort((a, b) -> a.start - b.start);
        List<Interval> res = new ArrayList<>();
        for(Interval interval : intervals) {
            if(res.isEmpty()) {
                res.add(interval);
                continue;
            }
            Interval prev = res.get(res.size() - 1);
            if(interval.start > prev.end) {
                res.add(interval);
            }
            else { // Update previous end in case of overlap
                prev.end = Math.max(prev.end, interval.end);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] timeSeries = {1, 2};
        mergeIntervals(timeSeries, 2);
    }

}
