// import java.util.*;

public class Q1TwoSumIIInputArrayIsSorted {
    // leetcode 167. Two Sum II - Input Array Is Sorted
    public int[] twoSum(int[] numbers, int target) {
        // Arrays.sort(numbers)

        int left = 0;
        int right = numbers.length - 1;
        int [] result = new int[2];

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                // 如果没有return, 这里会死循环, 因为left和right不变, 代码用于都会走到这里
                return result;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
