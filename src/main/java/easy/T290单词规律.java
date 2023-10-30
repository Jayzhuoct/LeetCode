package easy;

public class T290单词规律 {
    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }

    /*
    1. 将字符串s按空格分割成单词数组
    2. 如果单词数组的长度与模式字符串的长度不相等，返回false
    3. 遍历单词数组
        1. 如果模式字符串中当前字符的索引不等于单词数组中当前单词第一次出现的索引，返回false
    4. 循环结束后，表示所有字符的模式匹配都成功，返回true
    时间复杂度：O(n^2)
    空间复杂度：O(n)
     */
    public static boolean wordPattern(String pattern, String s) {
        // 将字符串s按空格分割成单词数组
        String[] words = s.split(" ");
        // 如果单词数组的长度与模式字符串的长度不相等，返回false
        if (words.length != pattern.length()) return false;
        // 遍历单词数组
        for (int i = 0; i < words.length; i++) {
            // 如果模式字符串中当前字符的索引不等于单词数组中当前单词第一次出现的索引，返回false
            if (pattern.indexOf(pattern.charAt(i)) != indexOf(words, words[i])) return false;
        }
        // 循环结束后，表示所有字符的模式匹配都成功，返回true
        return true;
    }

    private static int indexOf(String[] words, String word) {
        // 遍历单词数组
        for (int i = 0; i < words.length; i++) {
            // 如果当前单词与目标单词相等，返回当前单词的索引
            if (words[i].equals(word)) return i;
        }
        // 循环结束后，未找到目标单词，返回-1
        return -1;
    }
}
