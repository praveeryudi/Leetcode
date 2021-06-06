package array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _752_OpenLock {

    public static void main(String[] args) {
        String[] deadends = {"8888"};
        String target = "0009";
        int res = openLock(deadends, target);
        System.out.println(res);
    }

    private static int openLock(String[] deadends, String target) {

        Set<String> dead_ends = new HashSet<>();
        for(String str : deadends) {
            dead_ends.add(str);
        }

        Set<String> visited = new HashSet<>();
        visited.add("0000");

        Queue<String> q = new LinkedList<>();
        q.offer("0000");

        int move = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                String position = q.poll();
                if(dead_ends.contains(position)) {
                    size--;
                    continue;
                }

                if(position.equals(target))
                    return move;

                StringBuilder sb = new StringBuilder(position);
                for(int option = 0; option < 4; option++) {
                    char curr_char = sb.charAt(option);
                    // Next combination after incrementing
                    String s1 = sb.substring(0, option);
                    if(curr_char == '9') {
                        s1 += "0";
                    }
                    else {
                        s1 += String.valueOf(curr_char - '0' + 1);
                    }
                    s1 += sb.substring(option + 1);
                    if(!visited.contains(s1) && !dead_ends.contains(s1)) {
                        visited.add(s1);
                        q.offer(s1);
                    }

                    // Next combination after decrementing
                    String s2 = sb.substring(0, option);
                    if(curr_char == '0') {
                        s2 += "9";
                    }
                    else {
                        s2 += String.valueOf(curr_char - '0' - 1);
                    }
                    s2 += sb.substring(option + 1);
                    if(!visited.contains(s2) && !dead_ends.contains(s2)) {
                        visited.add(s2);
                        q.offer(s2);
                    }
                }

                size--;
            }
            move++;
        }

        return -1;
    }

}
