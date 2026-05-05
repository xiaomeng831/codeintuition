public class Q4ReverseWords {
    // leetcode 557. Reverse Words in a String III
    public String reverseWords(String s) {
        if (s == null || s.length() <= 1 || s.isBlank())
            return s;

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                continue;
            }

            int start = i;
            while (i < chars.length && chars[i] != ' ') {
                i++;
            }
            int end = i - 1;

            swap(start, end, chars);
        }

        return new String(chars);
    }

    private char[] swap(int left, int right, char[] chars) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return chars;
    }
}
