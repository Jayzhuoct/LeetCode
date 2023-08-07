package easy;

public class T387字符串中的第一个唯一字符 {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));

    }
    /*
    时间复杂度：O(n)
    - 第一个循环遍历字符串并更新计数数组的时间复杂度为 O(n)，其中 n 是字符串的长度。
    - 第二个循环遍历字符串并查找只出现一次的字符的时间复杂度为 O(n)。

    空间复杂度：O(1)
    - 数组 `arr` 的长度固定为 26，与输入字符串的长度无关。
    - 因此，无论输入字符串的长度如何，所需的额外空间都是常数级别的。
     */
    public static int firstUniqChar(String s) {
        int[] arr = new int[26]; // 创建一个长度为 26 的整数数组，用于记录每个字母出现的次数
        for (char c : s.toCharArray()) {
            arr[c - 'a']++; // 根据字符 c 减去字符 'a' 的 ASCII 值得到字母在数组中的索引，并将该索引处的值加一
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) // 如果字符 s.charAt(i) 减去字符 'a' 的 ASCII 值得到的索引处的值等于 1，表示该字符只出现了一次
                return i; // 返回该字符在字符串中的索引位置
        }
        return -1; // 如果字符串中没有只出现一次的字符，则返回 -1
    }
}
