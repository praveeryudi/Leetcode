package geeks;

import java.util.PriorityQueue;

/**
 * Given a square grid of size N, each cell of which contains integer cost which
 * represents a cost to traverse through that cell, we need to find a path from
 * top left cell to bottom right cell by which the total cost incurred is minimum.
 * From the cell (i,j) we can go (i,j-1), (i, j+1), (i-1, j), (i+1, j).
 *
 * Note: It is assumed that negative cost cycles do not exist in the input matrix.
 */
public class MinCostPath {

    private static class Cell {
        int x;
        int y;
        int distance;
        Cell(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    private static int minimumCostPath(int[][] grid)
    {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                dp[r][c] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = grid[0][0];
        PriorityQueue<Cell> pq = new PriorityQueue<>(rows * cols,
                (c1, c2) -> c1.distance - c2.distance);
        pq.offer(new Cell(0, 0, dp[0][0]));
        while(!pq.isEmpty()) {
            Cell current = pq.poll();
            int x = current.x;
            int y = current.y;
            // try left
            if (isWithinBounds(x, y - 1, rows, cols) && dp[x][y - 1] > (dp[x][y] + grid[x][y - 1])) {
                if (dp[x][y - 1] != Integer.MAX_VALUE) {
                    Cell toRemove = new Cell(x, y - 1, dp[x][y - 1]);
                    pq.remove(toRemove);
                }
                dp[x][y - 1] = dp[x][y] + grid[x][y - 1];
                pq.offer(new Cell(x, y - 1, dp[x][y - 1]));
            }
            // try up
            if (isWithinBounds(x-1, y, rows, cols) && dp[x-1][y] > (dp[x][y] + grid[x-1][y])) {
                if (dp[x-1][y] != Integer.MAX_VALUE) {
                    Cell toRemove = new Cell(x-1, y, dp[x-1][y]);
                    pq.remove(toRemove);
                }
                dp[x-1][y] = dp[x][y] + grid[x-1][y];
                pq.offer(new Cell(x-1, y, dp[x-1][y]));
            }
            // try right
            if (isWithinBounds(x, y + 1, rows, cols) && dp[x][y + 1] > (dp[x][y] + grid[x][y + 1])) {
                if (dp[x][y + 1] != Integer.MAX_VALUE) {
                    Cell toRemove = new Cell(x, y + 1, dp[x][y + 1]);
                    pq.remove(toRemove);
                }
                dp[x][y + 1] = dp[x][y] + grid[x][y + 1];
                pq.offer(new Cell(x, y + 1, dp[x][y + 1]));
            }
            // try down
            if (isWithinBounds(x+1, y, rows, cols) && dp[x+1][y] > (dp[x][y] + grid[x+1][y])) {
                if (dp[x+1][y] != Integer.MAX_VALUE) {
                    Cell toRemove = new Cell(x+1, y, dp[x+1][y]);
                    pq.remove(toRemove);
                }
                dp[x+1][y] = dp[x][y] + grid[x+1][y];
                pq.offer(new Cell(x+1, y, dp[x+1][y]));
            }
        }

        // Print dp
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                System.out.print(dp[r][c] + " ");
            }
            System.out.println("");
        }

        return dp[rows-1][cols-1];
    }

    private static boolean isWithinBounds(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {9,4,9,9},
                {6,7,6,4},
                {8,3,3,7},
                {7,4,9,10}
        };
        System.out.println("Minimum cost: " + minimumCostPath(grid));
    }


}
