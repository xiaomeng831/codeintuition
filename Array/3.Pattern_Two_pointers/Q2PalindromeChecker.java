public class Q2PalindromeChecker {
    public boolean palindromeChecker(String s) {

        // s.isEmpty()
        // - "" true
        // - " " false
        // - null NPE
        // s.isBlanlk()
        // - "" true
        // - " " true
        // - null NPE
        if (s == null || s.isBlank())
            return true;

        int left = 0;
        int right = s.length() - 1; // s.length()是方法, 有括号; s.length 是不对的

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            } else if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            } else {
                // 记得匹配成功也要移动指针!
                // 且要放到 else 中, 因为这些if...else可以看作是一个"原子操作"
                left++;
                right--;
            }

        }

        return true;
    }
}
