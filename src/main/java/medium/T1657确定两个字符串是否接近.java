package medium;

import java.util.Arrays;

public class T1657确定两个字符串是否接近 {
    public static void main(String[] args) {
        String word1 = "abc", word2 = "bca";
        System.out.println(closeStrings(word1,word2));
    }

    /*
        时间复杂度：O(n), n是字符串长度
        空间复杂度：O(1)
     */
    public static boolean closeStrings(String word1, String word2) {
        int[] c1 = new int[26];  // 用于统计字母出现次数的数组，索引0-25对应a-z
        int[] c2 = new int[26];  // 用于统计字母出现次数的数组，索引0-25对应a-z

        // 统计 word1 中每个字母的出现次数
        for (char c : word1.toCharArray()) {
            c1[c - 'a']++;  // 将字母转换为索引并增加对应位置的计数器
        }

        // 统计 word2 中每个字母的出现次数
        for (char c : word2.toCharArray()) {
            c2[c - 'a']++;  // 将字母转换为索引并增加对应位置的计数器
        }

        // 检查两个字符串中的字母是否完全相同或者缺失
        for (int i = 0; i < 26; i++) {
            if (c1[i] + c2[i] == 0) continue;  // 字母在两个字符串中均未出现，跳过
            if (c1[i] == 0 || c2[i] == 0) return false;  // 字母在其中一个字符串中缺失，返回 false
        }

        Arrays.sort(c1);  // 对 c1 数组进行排序
        Arrays.sort(c2);  // 对 c2 数组进行排序

        // 检查排序后的两个数组是否完全相同
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) return false;  // 有不相同的元素，返回 false
        }

        return true;  // 两个字符串满足条件，返回 true
    }
}
