package blind75.array;

public class ContainerWithMostWater {

    private static int getMax(int[] heights) {
        int n = heights.length;
        int maxWater = 0;
        int left = 0, right = n - 1;
        while(left < right) {
            int boundaryStorage = Math.min(heights[left], heights[right]) * (right - left);
            maxWater = Math.max(maxWater, boundaryStorage);
            if(heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        System.out.println(getMax(new int[] {1,8,6,2,5,4,8,3,7}));
    }

}
