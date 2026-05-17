import java.util.ArrayList;
import java.util.List;

public class Q3NegativeWindow_NotLC {

    // Given an integer array arr and a positive integer k, write a function to find
    // and return the count of negative numbers in every subarray of size k.
    // Example
    // Input: arr = [4, -4, 5, -1, 4], k = 3
    // Output: [1, 2, 1]
    // Explanation: Above is the count of negative numbers in each subarray of size 3.
    public List<Integer> negativeWindow(int[] arr, int k) {
        List<Integer> results = new ArrayList<>();

        if (arr == null || arr.length < k) {
            return results;
        }

        int windowCount = 0;

        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                windowCount++;
            }
        }

        results.add(windowCount);

        for (int i = 0; i < arr.length - k; i++) {
            if (arr[i] < 0) {
                windowCount--;
            }

            if (arr[i + k] < 0) {
                windowCount++;
            }

            results.add(windowCount);
        }

        return results;
    }
}
