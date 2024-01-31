package top150;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    private static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        while(!set.isEmpty()) {
            int x = set.iterator().next();
            set.remove(x);
            int lowerBound = x - 1;
            int upperBound = x + 1;
            while(set.contains(lowerBound)) {
                set.remove(lowerBound);
                lowerBound--;
            }
            while(set.contains(upperBound)) {
                set.remove(upperBound);
                upperBound++;
            }
            int len = upperBound - lowerBound - 1;
            maxLength = Math.max(maxLength, len);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }

}
