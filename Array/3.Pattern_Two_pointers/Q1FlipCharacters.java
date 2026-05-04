public class Q1FlipCharacters {
    public void flipCharacters(char[] arr) {
        if (arr == null || arr.length <= 1)
            return;

        // 致命错误: 不能直接使用 arr[0] 和 arr[arr.length - 1] 来初始化 left 和 right, 因为它们是字符, 而不是索引
        //int left = arr[0];
        //int right = arr[arr.length - 1];
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--; //right++ 是错误的，因为我们需要向左移动右指针, 而不是向右移动
        }

    }
}
