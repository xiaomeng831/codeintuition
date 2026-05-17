import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q4FourSum {
    // leetcode 18. 4Sum
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    // 先转成 long，避免 int 相加时溢出
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        results.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        int leftValue = nums[left];
                        int rightValue = nums[right];

                        while (left < right && nums[left] == leftValue) {
                            left++;
                        }
                        while (left < right && nums[right] == rightValue) {
                            right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return results;
    }
}
