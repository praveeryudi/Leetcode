package array;

public class _62_UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int paths = getUniquePath(7,3);
		System.out.println(paths);
	}
	
	private static int getUniquePath(int m, int n) {
		int rows = m;
		int cols = n;
		
		int[][] solution = new int[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			solution[i][0] = 1;
		}
		
		for(int j = 0; j < cols; j++) {
			solution[0][j] = 1;
		}
		
		for(int i = 1; i < rows; i++) {
			for(int j = 1; j < cols; j++) {
				solution[i][j] = solution[i][j-1] + solution[i-1][j];
			}
		}
		return solution[rows-1][cols-1];
	}

}
