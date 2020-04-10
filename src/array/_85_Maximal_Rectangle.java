package array;

import java.util.Stack;

public class _85_Maximal_Rectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = new int[][] { 
			{ 1, 0, 1, 0, 0 }, 
			{ 1, 0, 1, 1, 1 }, 
			{ 1, 1, 1, 1, 1 }, 
			{ 1, 0, 0, 1, 0 } };
			
		int maxArea = maximalRectangle(matrix);
		System.out.println("Max Area = " + maxArea);
	}

	private static int maximalRectangle(int[][] matrix) {

		int rows = matrix.length;
		int cols = matrix[0].length;
		int maximalArea = Integer.MIN_VALUE;

		int[] dp = new int[cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				dp[c] = matrix[r][c] == 0 ? 0 : dp[c] + 1;
			}
			int histogramArea = getHistogramMaxArea(dp);
			System.out.println(histogramArea);
			maximalArea = Math.max(histogramArea, maximalArea);
		}
		return maximalArea;
	}

	private static int getHistogramMaxArea(int[] heights) {

		int maxArea = Integer.MIN_VALUE;
		Stack<Integer> st = new Stack<Integer>();
		st.push(-1);

		for (int index = 0; index < heights.length; index++) {
			int currentBarHeight = heights[index];
			while (st.peek() != -1 && currentBarHeight <= heights[st.peek()]) {
				int height = heights[st.pop()];
				int width = index - st.peek() - 1;
				int area = height * width;
				maxArea = Math.max(area, maxArea);
			}
			st.push(index);
		}

		int len = heights.length;
		while (st.peek() != -1) {
			int height = heights[st.pop()];
			int width = len - st.peek() - 1;
			int area = height * width;
			maxArea = Math.max(area, maxArea);
		}
		return maxArea;
	}
}
