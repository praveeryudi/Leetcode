package array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * In a given grid, each cell can have one of three values:
 *
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * If this is impossible, return -1 instead.
 */
public class _994_RottingOranges {

    private static boolean isWithinBounds(int r, int c, int rows, int cols) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    private static int getMinTime(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;

        // Count all fresh oranges; if rotten - accept to queue
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1 )
                    fresh++;
                else if(grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        int[][] dirs = { {-1,0}, {0, 1}, {1,0}, {0, -1}};
        int minutes = 0;
        while(!q.isEmpty() || fresh > 0) {
            int size = q.size();
            while(size > 0) {
                int[] curr = q.poll();
                for(int[] dir : dirs) {
                    int newX = curr[0] + dir[0];
                    int newY = curr[1] + dir[1];

                    // If the new cell is within grid and is a fresh orange, flip it to rotten.
                    if(isWithinBounds(newX, newY, rows, cols) && grid[newX][newY] == 1) {
                        fresh--;
                        grid[newX][newY] = 2;
                        q.offer(new int[] {newX, newY});
                    }
                }
                size--;
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }

    public static void main(String[] args) {

    }
}
