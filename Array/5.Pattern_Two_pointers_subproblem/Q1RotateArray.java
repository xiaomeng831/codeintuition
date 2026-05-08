public class Q1RotateArray {
    public void rotate(int[] nums, int k) {
        
        // [1, 2, 3, 4, 5]
        // Part A = arr.length - k = 2
        // Part B = K = 3
        // STEP 1: reverse the arr 
        //         we will get reverse(B) reverse(A): [5, 4, 3, 2, 1]
        // STEP 2: reverse B to original: [3, 4, 5, 2, 1]
        // STEP 3: reverse A to original: [3, 4, 5, 1, 2]  
        // Important: k might be larger than arr.length, so we use the remainder

        
        k = k % nums.length;

        reverse(0, nums.length - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, nums.length - 1, nums);
    }

    private void reverse(int start, int end, int[] arr) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}
