package easy;

public class T14最长公共前缀 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix2(strs));


    }
    // 1. 横向扫描
    //时间复杂度：O(mn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量。
    //空间复杂度：O(1)。使用的额外空间复杂度为常数。
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String ans = strs[0]; // 以第一个字符串为基准
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            // 从第一个字符开始比较，如果不相等，就减少一个字符，再次比较
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) break;
            }
            ans = ans.substring(0, j); // 截取公共前缀
            if (ans.equals("")) return ans; // 如果公共前缀为空，直接返回
        }
        return ans;
    }
    // 2. 纵向扫描
    //时间复杂度：O(mn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量。
    //空间复杂度：O(1)。使用的额外空间复杂度为常数。
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        // 以第一个字符串为基准
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i); // 获取第一个字符串的第i个字符
            // 从第二个字符串开始比较，如果不相等，就减少一个字符，再次比较
            for (int j = 1; j < strs.length; j++) {
                // 如果第j个字符串的第i个字符不等于c，或者第j个字符串的长度小于i
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i); // 截取公共前缀
                }
            }
        }
        return strs[0];
    }
}
