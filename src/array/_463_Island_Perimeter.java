package array;

public class _463_Island_Perimeter {

    private static int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    perimeter += 4;
                    if(j > 0 && grid[i][j-1] == 1)
                        perimeter -= 2;
                    if(i > 0 && grid[i-1][j] == 1)
                        perimeter -= 2;
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };

        System.out.println(islandPerimeter(arr));
    }

}
