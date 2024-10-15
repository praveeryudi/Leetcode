package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class RatInMaze {
    private static class Cell {
        int x;
        int y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public String toString() {
            return x + "-" + y;
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1,0,1},
                {1,0,1},
                {1,1,1}
        };
        ratInAMaze(maze, 3);
    }

    public static void ratInAMaze(int[][] maze, int n) {
        // Write your code here.
        ArrayList<ArrayList<Cell>> res = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        dfs(maze,0,0,visited,new ArrayList<>(),res);
        System.out.println(res);

        int[][] output = new int[n][n];
        for(ArrayList<Cell> cellList : res) {
            for(Cell cell : cellList) {
                output[cell.x][cell.y] = 1;
            }
        }
        System.out.println(Arrays.deepToString(output));
    }

    private static void dfs(int[][] grid, int r, int c, boolean[][] visited, ArrayList<Cell> current,
            ArrayList<ArrayList<Cell>> res) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0)
            return;
        if(visited[r][c])
            return;
        visited[r][c] = true;
        current.add(new Cell(r,c));
        if(r == grid.length - 1 && c == grid[0].length - 1) {
            res.add(new ArrayList<>(current));
            return;
        }
        dfs(grid,r,c-1,visited,current,res);
        dfs(grid,r-1,c,visited,current,res);
        dfs(grid,r,c+1,visited,current,res);
        dfs(grid,r+1,c,visited,current,res);
        current.remove(current.size()-1);
        visited[r][c] = false;
    }
}
