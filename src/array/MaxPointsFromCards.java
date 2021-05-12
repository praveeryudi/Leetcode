package array;

/**
 * here are several cards arranged in a row, and each card has an associated number of points.
 * The points are given in the integer array cardPoints.
 *
 * In one step, you can take one card from the beginning or from the end of the row.
 * You have to take exactly k cards.
 *
 * Your score is the sum of the points of the cards you have taken.
 *
 * Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 */
public class MaxPointsFromCards {

    public static void main(String[] args) {
        int[] cards = {1,79,80,1,1,1,200,1};
        int res = getMaxPoints(cards, 3);
        System.out.println("Max Points: " + res);
    }

    private static int getMaxPoints(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }
        if(n == k)
            return sum;

        int leftSum = 0;
        int rightSum = 0;

        for(int index = 0; index < k; index++) {
            leftSum += nums[index];
        }

        int maxSum = leftSum;
        int leftWindow = k-1;
        int rightWindow = nums.length - 1;

        while(leftWindow >= 0) {
            leftSum -= nums[leftWindow];
            rightSum += nums[rightWindow];
            maxSum = Math.max(maxSum, leftSum + rightSum);
            leftWindow--;
            rightWindow--;
        }
        return maxSum;
    }

}
