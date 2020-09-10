package array;

import java.util.ArrayList;
import java.util.List;

public class _949_Largest_Time {

    private static String largestTimeFromDigits(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        permute(arr, 0, arr.length - 1, result);
        System.out.println(result);

        List<String> validList = new ArrayList<>();
        for (List<Integer> time : result) {
            String timeStr = "";
            for (int t : time) {
                timeStr += t;
            }
            System.out.println(timeStr);
            if (isValidTime(timeStr)) {
                validList.add(timeStr);
            }
        }
        if (validList.isEmpty())
            return "";
        String output = validList.get(validList.size() - 1);
        return output.substring(0, 2) + ":" + output.substring(2, 4);
    }

    private static boolean isValidTime(String input) {
        if (input.charAt(0) > '2') return false;
        if (input.charAt(0) == '2' && input.charAt(1) > '3') return false;
        if (input.charAt(2) >= '6') return false;
        return true;
    }

    private static void permute(int[] nums, int start, int end, List<List<Integer>> result) {
        if (start > end) return;
        if (start == end) {
            List<Integer> l = new ArrayList<>();
            for (int x : nums)
                l.add(x);
            result.add(l);
        }
        for (int i = start; i <= end; i++) {
            swap(nums, start, i);
            permute(nums, start + 1, end, result);
            swap(nums, start, i);
        }
    }

    private static void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }

    public static void main(String[] args) {
        int[] digits = {1,2,3,4};
        String res = largestTimeFromDigits(digits);
        System.out.println("Largest Time = " + res);
    }
}
