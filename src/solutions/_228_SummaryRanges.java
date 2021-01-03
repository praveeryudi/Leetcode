package solutions;

import java.util.*;

public class _228_SummaryRanges {

    private static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(null == nums || nums.length == 0)
            return res;

        Deque<Integer> q = new LinkedList<>();
        q.add(nums[0]);

        for(int index = 1; index < nums.length; index++) {
            int curr = nums[index];
            if(curr - q.peekLast() == 1) {
                q.addLast(curr);
            }
            else {
                int size = q.size();
                String output = "";
                while(!q.isEmpty()) {
                    if(q.size() == size)
                        output += q.pollFirst() + "->";
                    if(q.size() == 1)
                        output += q.pollFirst() + "->";
                    q.poll();
                }
                q.addLast(curr);
                res.add(output.substring(0, output.length() - 2));
            }
        }
        String rem = "";
        int size = q.size();
        while(!q.isEmpty())
        {
            if(q.size() == size)
                rem += q.pollFirst() + "->";
            if(q.size() == 1)
                rem += q.pollFirst() + "->";
            q.poll();
        }

        res.add(rem.substring(0, rem.length() - 2));

        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2};
        summaryRanges(nums);
    }

}
