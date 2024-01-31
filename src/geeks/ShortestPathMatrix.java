package geeks;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathMatrix {

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,0,1,1,1,1,0,1,1,1},
                {1,0,1,0,1,1,1,0,1,1},
                {1,1,1,0,1,1,0,1,0,1},
                {0,0,0,0,1,0,0,0,0,1},
                {1,1,1,0,1,1,1,0,1,0},
                {1,0,1,1,1,1,0,1,0,0},
                {1,0,0,0,0,0,0,0,0,1},
                {1,0,1,1,1,1,0,1,1,1},
                {1,1,0,0,0,0,1,0,0,1}
        };

        Point src = new Point(0,0);
        Point dest = new Point(3,4);
        int dist = shortestPathBinaryMatrix(matrix, src, dest);
        System.out.println(dist);
    }

    public static int shortestPathBinaryMatrix(int[][] matrix, Point src, Point dest) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int distance = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                Point p = q.poll();
                if(p.x == dest.x && p.y == dest.y) {
                    return distance;
                }
                // go left
                if(withinBounds(p.x, p.y-1, rows, cols) && matrix[p.x][p.y-1] == 1 && !visited[p.x][p.y-1]) {
                    visited[p.x][p.y-1] = true;
                    q.add(new Point(p.x, p.y-1));
                }
                // go up
                if(withinBounds(p.x-1, p.y, rows, cols) && matrix[p.x-1][p.y] == 1 && !visited[p.x-1][p.y]) {
                    visited[p.x-1][p.y] = true;
                    q.add(new Point(p.x-1, p.y));
                }
                // go right
                if(withinBounds(p.x, p.y+1, rows, cols) && matrix[p.x][p.y+1] == 1 && !visited[p.x][p.y+1]) {
                    visited[p.x][p.y+1] = true;
                    q.add(new Point(p.x, p.y+1));
                }
                // go down
                if(withinBounds(p.x + 1, p.y, rows, cols) && matrix[p.x+1][p.y] == 1 && !visited[p.x+1][p.y]) {
                    visited[p.x+1][p.y] = true;
                    q.add(new Point(p.x+1, p.y));
                }
                size--;
            }
            distance++;
        }
        return distance;
    }

    private static boolean withinBounds(int x, int y, int rows, int cols) {
        return x >= 0 && y >= 0 && x < rows && y < cols;
    }

}
