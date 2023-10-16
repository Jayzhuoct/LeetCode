package medium;

public class T1143最长公共子序列 {
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    /*
        动态规划
        时间复杂度是O(m * n)，其中m是字符串text1的长度，n是字符串text2的长度。
        这是因为代码中使用了两个嵌套的循环来遍历text1和text2的所有字符，并且在每个循环中执行常数时间的操作。

        代码中创建了一个二维数组dp，其大小为(m + 1) * (n + 1)，
        因此空间复杂度为O(m * n)。
        这是因为需要存储text1和text2的所有字符之间的最长公共子序列的长度。
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(); // 获取text1的长度
        int n = text2.length(); // 获取text2的长度
        int[][] dp = new int[m + 1][n + 1]; // 创建一个二维数组dp，用于存储最长公共子序列的长度

        for (int i = 1; i <= m; i++) { // 遍历text1的每个字符
            char c1 = text1.charAt(i - 1); // 获取text1中当前位置的字符

            for (int j = 1; j <= n; j++) { // 遍历text2的每个字符
                char c2 = text2.charAt(j - 1); // 获取text2中当前位置的字符

                if (c1 == c2) { // 如果两个字符相等
                    dp[i][j] = dp[i - 1][j - 1] + 1; // 在dp数组中，当前位置的值等于左上方对角线上的值加1，表示最长公共子序列的长度增加了1
                } else { // 如果两个字符不相等
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // 在dp数组中，当前位置的值等于左方位置和上方位置的值中的较大值，表示当前最长公共子序列的长度不变
                }
            }
        }
        return dp[m][n]; // 返回dp数组右下角的值，即最长公共子序列的长度
    }
}
