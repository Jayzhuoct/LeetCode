package easy;

public class T392判断子序列 {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    /*
    * 双指针
    * 时间复杂度：O(n+m)，其中 n 和 m 分别是字符串 s 和 t 的长度。
    * 每次无论是匹配成功还是失败，都有至少一个指针发生右移，两指针能够位移的总距离为 n+m。
    * 空间复杂度：O(1)。
     */
    public static boolean isSubsequence(String s, String t) {
        int index = -1;  // 当前字符在字符串t中匹配的起始索引位置，初始化为-1
        for (char c : s.toCharArray()) {  // 遍历字符串s中的每个字符
            index = t.indexOf(c, index + 1);  // 在字符串t中从上次匹配位置之后开始查找字符c的索引
            if (index == -1) {  // 如果找不到字符c，则表示s不是t的子序列
                return false;
            }
        }
        return true;  // 如果能够遍历完字符串s中的所有字符，并且每个字符都能在t中找到匹配，则s是t的子序列
    }
}
