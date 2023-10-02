package medium;

public class T2390从字符串中移除星号 {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(removeStars(s));
    }

    /*
        时间复杂度：O(n)，其中 n 是字符串 s 的长度。
        空间复杂度：O(n)。
     */
    public static String removeStars(String s) {
        StringBuilder sb = new StringBuilder(); // 创建一个可变的字符串对象，用于构建结果字符串
        for (int i = 0; i < s.length(); i++) { // 遍历输入字符串的每个字符
            if (s.charAt(i) != '*') // 如果当前字符不是星号
                sb.append(s.charAt(i)); // 将当前字符添加到结果字符串中
            else { // 如果当前字符是星号
                if (sb.length() > 0) // 如果结果字符串不为空
                    sb.deleteCharAt(sb.length() - 1); // 则删除结果字符串中的最后一个字符
            }
        }
        return sb.toString(); // 将结果字符串转换为普通字符串并返回
    }
}
