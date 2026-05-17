import java.util.Arrays;

public class Q3ThreeSumClosest {
    // leetcode 16. 3Sum Closest
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int theClosest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                theClosest = Math.abs(sum - target) < Math.abs(theClosest - target) ? sum : theClosest;

                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return theClosest;
    }
}
