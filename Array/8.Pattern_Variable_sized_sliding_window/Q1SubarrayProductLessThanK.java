public class Q1SubarrayProductLessThanK {
    // leetcode 713. Subarray Product Less Than K
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 0)
            return 0;

        int left = 0;
        int product = 1;
        int answer = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left];
                left++;
            }

            // 以 right 结尾的子数组, 最早只能从 left 开始。
            // 从 left 到 right 之间的每个位置, 都可以当开头
            // 等价于你脑子里偷偷做了这个循环：
            // for (int start = left; start <= right; start++) {
            //     arr[start ... right] 都是合法子数组
            //     answer++;
            // }
            // 只是我们不真的写这个循环, 因为那样会慢
            answer += right - left + 1;
        }

        return answer;
    }
}
