package _30daychallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringShifts {

    private static List<Character> list = new ArrayList<>();

    private static String stringShift(String s, int[][] shift) {

        char[] chars = s.toCharArray();
        for(char ch : chars) {
            list.add(ch);
        }

        for(int[] arr : shift) {
            int dir = arr[0];
            int amt = arr[1];

            // Left Shift
            if(dir == 0) {
                leftShift(amt);
            }
            else if(dir == 1) {
                rightShift(amt);
            }
            else {
                return "";
            }
        }
        return list.stream().map(Object::toString)
                .collect(Collectors.joining(""));
    }

    private static void leftShift(int amt) {
        for(int i = 0; i < amt; i++) {
            char ch = list.remove(0);
            list.add(ch);
        }
    }

    private static void rightShift(int amt) {
        for(int i = 0; i < amt; i++) {
            char ch = list.remove(list.size() - 1);
            list.add(0, ch);
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int[][] shifts = new int[][] {
                {1,1},
                {1,1},
                {0,2},
                {1,3}
        };
        String output = stringShift(s, shifts);
        System.out.println(output);
    }
}
