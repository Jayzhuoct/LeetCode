package easy;

public class T1768交替合并字符串 {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
        System.out.println(mergeAlternately("ab", "pqrs"));
        System.out.println(mergeAlternately("abcd", "pq"));
    }

    /*
        时间复杂度O(n)
        空间复杂度O(n)
     */
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();  // 创建一个可变字符串对象，用于构建合并后的结果
        int i = 0;  // 用于追踪两个输入字符串的当前位置
        // 循环迭代，直到其中一个字符串的所有字符都被处理完为止
        for (; i < word1.length() && i < word2.length(); i++) {
            sb.append(word1.charAt(i));  // 将word1的当前字符追加到结果字符串中
            sb.append(word2.charAt(i));  // 将word2的当前字符追加到结果字符串中
        }
        // 如果word1还有剩余字符，则将剩余部分追加到结果字符串中
        if (i < word1.length()) {
            sb.append(word1.substring(i));
        }
        // 如果word2还有剩余字符，则将剩余部分追加到结果字符串中
        if (i < word2.length()) {
            sb.append(word2.substring(i));
        }
        return sb.toString();  // 将结果字符串转换为普通的不可变字符串并返回
    }
}
