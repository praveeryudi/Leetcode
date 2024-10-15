package array;

import java.util.LinkedList;
import java.util.Queue;

public class GoForGold {

    public static void main(String[] args) {
        int[][] grid = {
                {0,1,1,2,0},
                {2,2,1,1,2},
                {0,0,1,2,0},
                {0,1,1,0,0}
        };
        int moves = goForGold(grid, 2, 1);
        System.out.println("# of moves : " + moves);
    }

    private static class Cell {
        int x;
        int y;
        int step;
        Cell(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
        @Override
        public String toString() {
            return "[" + x + " : " + y + " : " + step + "]";
        }
    }

    public static int goForGold(int[][] arr, int x, int y) {
        // Write your code here.

        int rows = arr.length;
        int cols = arr[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int totalGold = 0;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(arr[r][c] == 1) {
                    totalGold ++;
                }
            }
        }

        Queue<Cell> q = new LinkedList<>();
        q.offer(new Cell(0,0,0));
        visited[0][0] = true;

        while(!q.isEmpty()) {

                Cell curr = q.poll();
                int a = curr.x;
                int b = curr.y;

                if(a == x && b == y && totalGold == 0) {
                    return curr.step;
                }

                // check left
                if(b-1 >= 0 && arr[a][b-1] != 2) {
                    q.offer(new Cell(a, b-1, curr.step + 1));
                    if(!visited[a][b-1] && arr[a][b-1] == 1) {
                        visited[a][b-1] = true;
                        totalGold -= 1;
                    }
                }
                // check up
                if(a-1 >= 0 && arr[a-1][b] != 2) {
                    q.offer(new Cell(a-1, b, curr.step + 1));
                    if(!visited[a-1][b] && arr[a-1][b] == 1) {
                        visited[a-1][b] = true;
                        totalGold -= 1;
                    }
                }
                // check right
                if(b+1 < cols && arr[a][b+1] != 2) {
                    q.offer(new Cell(a, b+1, curr.step + 1));
                    if(!visited[a][b+1] && arr[a][b+1] == 1) {
                        visited[a][b+1] = true;
                        totalGold -= 1;
                    }
                }
                // check down
                if(a+1 < rows && arr[a+1][b] != 2) {
                    q.offer(new Cell(a+1, b, curr.step + 1));
                    if(!visited[a+1][b] && arr[a+1][b] == 1) {
                        visited[a+1][b] = true;
                        totalGold -= 1;
                    }
                }
        }
        return -1;
    }
}
