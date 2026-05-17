public class Q1MaximumAverageSubarrayI {
    // leetcode 643. Maximum Average Subarray I
    public double findMaxAverage(int[] nums, int k) {
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        for (int i = 0; i < nums.length - k; i++) {
            windowSum = windowSum - nums[i] + nums[i + k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }
}
