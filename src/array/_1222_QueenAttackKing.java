package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1222_QueenAttackKing {

    private static List<List<Integer>> queensAttackTheKing(int[][] queens, int[] king) {

        List<List<Integer>> res = new ArrayList<>();
        // 1. Initialize a 8x8 board
        boolean[][] board = new boolean[8][8];
        // 2. Set all queen occupied cells as true
        for(int[] queen : queens) {
            board[queen[0]][queen[1]] = true;
        }

        // 3. Initialize directions array
        int[] dir = {-1, 0, 1};
        for(int dx : dir) {
            for(int dy : dir) {
                if(dx == 0 && dy == 0)
                    continue;

                int kx = king[0];
                int ky = king[1];
                // Check within bounds
                while(kx + dx >= 0 && kx + dx < 8 && ky + dy >= 0 && ky + dy < 8) {
                    kx += dx;
                    ky += dy;
                    if(board[kx][ky]) {
                        res.add(Arrays.asList(kx, ky));
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] queens = {
                {0,1},
                {1,0},
                {4,0},
                {0,4},
                {3,3},
                {2,4}
        };
        int[] king = {0,0};
        List<List<Integer>> output = queensAttackTheKing(queens, king);
        System.out.println(output);
    }

}
