package medium;

public class T151反转字符串中的单词 {
    public static void main(String[] args) {
        String s = "  hello world!  ";
        System.out.println(reverseWords(s));
    }

    /*
        * 正则表达式
        *
        * 时间复杂度为 O(n)，其中 n 是字符串 s 的长度，
        * 因为需要遍历字符串中的每个字符一次。
        *
        * 空间复杂度为 O(n)，其中 n 是字符串 s 的长度，
        * 因为需要使用 O(n) 的空间存储字符串的数组。
     */
    public static String reverseWords(String s) {
        // 删除首尾空格
        s = s.trim();
        // 正则匹配连续的空格作为分隔符分割字符串
        String[] strs = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        // 倒序遍历字符串数组
        for (int i = strs.length - 1; i >= 0; i--) {
            res.append(strs[i]).append(" ");
        }
        // 删除最后一个空格
        return res.toString().trim();
    }
}
