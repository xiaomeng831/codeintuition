import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q4EvenOddCount_NotLC {
    // Given an integer array arr and a positive integer k, write a function to find
    // and return the count of even and odd numbers, respectively, in every subarray
    // of size k.
    // Example
    // Input: arr = [4, 4, 5, 1, 4], k = 3
    // Output: [[2, 1], [1, 2], [1, 2]]
    // Explanation: Above is the count of even and odd numbers in each subarray of size 3.
    public List<List<Integer>> evenOddCount(int[] arr, int k) {
        List<List<Integer>> results = new ArrayList<>();

        if (arr == null || arr.length < k) {
            return results;
        }

        int windowEvenCount = 0;
        int windowOddCount = 0;

        for (int i = 0; i < k; i++) {
            if (arr[i] % 2 == 0) {
                windowEvenCount++;
            } else {
                windowOddCount++;
            }
        }

        results.add(Arrays.asList(windowEvenCount, windowOddCount));

        for (int i = 0; i < arr.length - k; i++) {
            if (arr[i] % 2 == 0) {
                windowEvenCount--;
            } else {
                windowOddCount--;
            }

            if (arr[i + k] % 2 == 0) {
                windowEvenCount++;
            } else {
                windowOddCount++;
            }

            results.add(Arrays.asList(windowEvenCount, windowOddCount));
        }

        return results;
    }
}
