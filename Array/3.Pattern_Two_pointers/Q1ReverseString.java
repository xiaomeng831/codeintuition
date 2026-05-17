public class Q1ReverseString {
    // leetcode 344. Reverse String
    public void reverseString(char[] s) {
        if (s == null || s.length <= 1)
            return;

        // 致命错误: 不能直接使用 s[0] 和 s[s.length - 1] 来初始化 left 和 right, 因为它们是字符, 而不是索引
        // int left = s[0];
        // int right = s[s.length - 1];
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--; // right++ 是错误的，因为我们需要向左移动右指针, 而不是向右移动
        }

    }
}
