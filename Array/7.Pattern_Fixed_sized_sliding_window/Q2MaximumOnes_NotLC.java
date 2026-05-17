public class Q2MaximumOnes_NotLC {
    // Given a binary array arr and a positive integer k, write a function to find
    // and return the maximum number of 1's among all subarrays of size k.
    // Example
    // Input: arr = [1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0], k = 5
    // Output: 4
    // Explanation: The maximum number of 1s among all subarrays of size 5 is 4.

    public int maximumOnes(int[] arr, int k) {
        int windowsCount = 0;

        for (int i = 0; i < k; i++) {
            if (arr[i] == 1) {
                windowsCount++;
            }
        }

        int maxCount = windowsCount;

        for (int i = 0; i < arr.length - k; i++) {
            if (arr[i] == 1)
                windowsCount--;
            if (arr[i + k] == 1)
                windowsCount++;

            maxCount = Math.max(maxCount, windowsCount);
        }

        return maxCount;
    }
}
