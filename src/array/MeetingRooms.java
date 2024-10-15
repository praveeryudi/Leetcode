package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingRooms {

    public static void main(String[] args) {
        int[][] intervals = {
                {0100, 0400},
                {0300, 0500},
                {0400, 0600}
        };
        int ans = minRooms(intervals);
        System.out.println(ans);
    }

    public static int minRooms(int[][] intervals) {
        // Write your code here.

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int rooms = 0;
        List<int[]> list = new ArrayList<>();
        for(int[] curr : intervals) {
            if(list.isEmpty()) {
                //rooms++;
                list.add(curr);
                continue;
            }

            int[] prev = list.get(list.size() - 1);
            if(prev[1] <= curr[0]) { // no overlap
                list.add(curr);
            } else {
                rooms++;
                prev[1] = Math.max(prev[1], curr[1]);
            }
        }
        return rooms;
    }
}
