package hard;

public class T72编辑距离 {
    public static void main(String[] args) {
        String word1 = "", word2 = "ros";
        System.out.println(minDistance2(word1, word2));
    }

    /*
    动态规划

    使用动态规划方法解决该问题，通过填充和更新一个二维数组dp来存储中间结果和最终结果。

    首先，函数获取输入字符串word1和word2的长度，并进行一些边界情况的处理。
    如果其中一个字符串为空，那么将另一个字符串的长度作为最少操作数返回。

    然后，函数初始化二维数组dp，其中dp[i][j]表示将word1的前i个字符转换为word2的前j个字符所需的最少操作数。
    初始化时，将dp[i][0]设置为i，表示将word1的前i个字符转换为空字符串所需的操作数；
    将dp[0][j]设置为j，表示将空字符串转换为word2的前j个字符所需的操作数。

    接下来，使用状态转移的方式来填充dp数组。对于word1的每个字符c1，以及word2的每个字符c2，根据当前字符是否相等，进行不同的操作。

    如果c1和c2相等，那么不需要进行任何操作，即dp[i][j] = dp[i - 1][j - 1]。
        如果c1和c2不相等，那么需要进行插入、删除或替换操作，并取三者中的最小值。具体操作包括：
        插入：将c2插入到word1中，即dp[i][j] = dp[i][j - 1] + 1。
        删除：删除word1中的c1，即dp[i][j] = dp[i - 1][j] + 1。
        替换：将c1替换为c2，即dp[i][j] = dp[i - 1][j - 1] + 1。
        最后，函数返回dp[n1][n2]，即将word1转换为word2所需的最少操作数。

    时间复杂度为O(n1 * n2)，其中n1和n2分别是word1和word2的长度。
    这是因为代码中有两个嵌套的循环，分别遍历word1和word2的所有字符，每次循环都会进行常数时间的操作。

    空间复杂度为O(n1 * n2)，因为使用了一个二维数组dp来存储中间结果和最终结果。
    该数组的大小为(n1 + 1) * (n2 + 1)，与输入字符串的长度成正比。
     */
    public static int minDistance1(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        if (n1*n2 == 0) return n1 + n2;// 如果有一个字符串为空，则需要操作的次数为另一个字符串的长度
        // dp[i][j]表示word1的前i个字符转换成word2的前j个字符所需要的最少操作数
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 初始化
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n2; j++) {
            dp[0][j] = j;
        }
        // 状态转移
        for (int i = 1; i <= n1; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= n2; j++) {
                char c2 = word2.charAt(j - 1);
                // 如果当前字符相等，则不需要操作，dp[i][j] = dp[i - 1][j - 1]
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // 如果当前字符不相等，则需要进行插入、删除、替换操作，取三者最小值
                else {
                    // 插入：dp[i][j] = dp[i][j - 1] + 1
                    // 删除：dp[i][j] = dp[i - 1][j] + 1
                    // 替换：dp[i][j] = dp[i - 1][j - 1] + 1
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1]
                            [j - 1]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }

    /*
    优化

    优化的版本使用一个一维数组dp（长度为n2 + 1）来存储中间结果。
    在状态转移过程中，我们只需要使用dp[j - 1]、dp[j]和pre（即dp[i - 1][j]）的值，而不需要使用整个二维数组。

    在循环开始之前，我们先将一维数组dp进行初始化，将dp[j]设置为j，表示将空字符串转换为word2的前j个字符所需的操作数。

    然后，在状态转移的过程中，我们使用变量pre来保存dp[i - 1][j - 1]的值，即上一行的当前列的值。
    在内层循环中，我们先将dp[j]保存到临时变量temp中，然后根据c1和c2是否相等来更新dp[j]的值。
    最后，将temp的值赋给pre，以便在下一次循环中使用。

    最后，我们返回dp[n2]，即将word1转换为word2所需的最少操作数。

    通过这种优化，我们将空间复杂度从O(n1 * n2)降低为O(n2)，在空间上节省了一部分的额外开销。
     */
    public static int minDistance2(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        if (n1 * n2 == 0) return n1 + n2;

        // 优化后的滚动数组
        int[] dp = new int[n2 + 1];

        // 初始化
        for (int j = 0; j <= n2; j++) {
            dp[j] = j;
        }

        // 状态转移
        for (int i = 1; i <= n1; i++) {
            int pre = dp[0]; // 保存dp[i-1][j-1]的值
            dp[0] = i; // 更新dp[i][0]

            for (int j = 1; j <= n2; j++) {
                int temp = dp[j]; // 保存dp[i-1][j]的值
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[j] = pre;
                } else {
                    dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), pre) + 1;
                }
                pre = temp; // 更新pre为dp[i-1][j]
            }
        }

        return dp[n2];
    }
}
