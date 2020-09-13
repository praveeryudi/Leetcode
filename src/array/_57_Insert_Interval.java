package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _57_Insert_Interval {

    private static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> output = new ArrayList<>();
        if(intervals.length == 0) {
            output.add(newInterval);
        }

        // Case I: If new interval is before the first interval
        if(newInterval[1] < intervals[0][0]) {
            output.add(newInterval);
            output.addAll(Arrays.asList(intervals));
        }
        // Case II: If new interval is after all intervals
        else if(newInterval[0] > intervals[intervals.length-1][1]) {
            output.addAll(Arrays.asList(intervals));
            output.add(newInterval);
        }
        /// Case III: If the new interval overlaps with existing intervals
        else {
            for(int index = 0; index < intervals.length; index++) {
                int[] interval = intervals[index];
                if(interval[1] < newInterval[0]) {
                    output.add(interval);
                }
                else if(newInterval[1] < interval[0]) {
                    if(!output.contains(newInterval))
                        output.add(newInterval);
                    output.add(interval);
                }
                else {
                    int intStart = Math.min(interval[0], newInterval[0]);
                    int intEnd = Math.max(interval[1], newInterval[1]);
                    newInterval = new int[] {intStart, intEnd};
                }
            }

            if(!output.contains(newInterval))
                output.add(newInterval);
        }

        int[][] res = new int[output.size()][2];
        for(int i = 0; i < output.size(); i++) {
            res[i] = output.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] input = {
                {0,2},
                {3,9}
        };
        int[] newInterval = {6,8};
        int[][] result = insert(input, newInterval);
        System.out.println(Arrays.toString(result));
    }
}
