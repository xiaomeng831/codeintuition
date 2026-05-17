import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2ThreeSum {
    // leetcode 15. 3Sum
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 找到一个答案后, 直接跳过所有和当前 left/right 相同的值
                    int leftValue = nums[left];
                    int rightValue = nums[right];

                    while (left < right && nums[left] == leftValue) {
                        left++;
                    }

                    while (left < right && nums[right] == rightValue) {
                        right--;
                    }

                    // 另一种写法: 先跳到重复值的边界, 然后再额外移动一步, 离开当前值
                    // while(left < right && nums[left] == nums[left + 1]) {
                    //     left++;
                    // }
                    // while(left < right && nums[right] == nums[right - 1]) {
                    //     right--;
                    // }
                    // left++;
                    // right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return results;
    }
}
