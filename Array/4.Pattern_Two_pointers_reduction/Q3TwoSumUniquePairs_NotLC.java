import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3TwoSumUniquePairs_NotLC {
    public List<List<Integer>> duplicateAwareTwoSum(
            int[] arr,
            int target) {

        Arrays.sort(arr);
        List<List<Integer>> results = new ArrayList<>();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                results.add(Arrays.asList(arr[left], arr[right]));

                int leftStart = arr[left];
                int rightStart = arr[right];

                while (left < right && arr[left] == leftStart) {
                    left++;
                }

                while (left < right && arr[right] == rightStart) {
                    right--;
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return results;
    }
}
