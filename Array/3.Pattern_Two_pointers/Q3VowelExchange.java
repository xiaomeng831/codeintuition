import java.util.*;

public class Q3VowelExchange {
    // leetcode 345. Reverse Vowels of a String
    public String vowelExchange(String s) {
        Set<Character> vowels = new HashSet<>();
        // HashSet 没有set 方法, 是add
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        int left = 0;
        int right = s.length() - 1;

        // String 是 immutable的，交换String中元素的题, 需要变成 char[]
        char[] chars = s.toCharArray();

        while (left < right) {
            // 多此一举
            // char leftChar = chars[left];
            // char rightChar = chars[right];

            if (!vowels.contains(chars[left])) {
                left++;
            } else if (!vowels.contains(chars[right])) {
                right--;
            } else {
                // 不会改变数组内容
                // 必须直接用 chars[left] 和 chars[right]
                // 而不是 leftChar 和 rightChar
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }
        }
        return new String(chars);
    }

    // 进阶 - 不用 HashSet
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    // 拓展 - 构造函数中直接设置值 HashSet(Collection<? extends E> c)
    // Arrays 工具类中的静态方法 Arrays.asList() 返回一个 List, 而 HashSet 的构造函数需要一个 Collection,
    // List 又是 Collection 的子接口, 所以可以直接传入 Arrays.asList() 的结果
    Set<Character> vowels2 = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
}
