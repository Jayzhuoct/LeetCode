package medium;

public class T279完全平方数 {
    public static void main(String[] args) {
        System.out.println(numSquares1(12));
        System.out.println(numSquares2(12));
    }

    /*
        动态规划
        此函数用于计算一个数 n 的最少完全平方数的数量。

        参数：
        - n: 要计算的数

        返回值：
        - 最少完全平方数的数量

        算法步骤：
        1. 创建一个长度为 n+1 的数组 f，用于存储每个数的最少完全平方数数量。数组初始化为全零。
        2. 从 1 开始遍历到 n：
           a. 初始化一个变量 minn，用于存储当前数的最小完全平方数数量，初始值设为一个较大的整数（Integer.MAX_VALUE）。
           b. 再次从 1 遍历到 i 的平方根（j * j <= i）：
              - 计算当前数减去 j 的平方后的索引 i - j * j。
              - 根据索引 i - j * j 在数组 f 中的值，更新 minn 为 min(minn, f[i - j * j])。
           c. 将 f[i] 设为 minn + 1，即当前数的最少完全平方数数量。
        3. 返回 f[n]，即目标数 n 的最少完全平方数数量。

        时间复杂度：O(n * sqrt(n))，其中 n 为目标数。外层循环需要遍历 n 次，内层循环需要遍历 sqrt(n) 次。
        空间复杂度：O(n)，其中 n 为目标数。需要创建一个长度为 n+1 的数组。
     */
    public static int numSquares1(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }

    /*
        数学

        参数：
        - n: 要计算的数

        返回值：
        - 最少完全平方数的数量

        算法步骤：
        1. 如果 n 是一个完全平方数，则返回 1。
        2. 如果 n 可以表示为 4^k*(8m+7) 的形式，则返回 4。其中 k 和 m 是非负整数。
        3. 否则，遍历从 1 开始到平方根小于等于 n 的数 i：
           a. 计算 j = n - i * i。
           b. 如果 j 是一个完全平方数，则返回 2。
        4. 如果以上条件都不满足，则返回 3。

        辅助函数：
        - isPerfectSquare(x)：判断一个数是否为完全平方数。
           - 参数：x - 要判断的数。
           - 返回值：如果 x 是一个完全平方数，则返回 true；否则返回 false。
        - checkAnswer4(x)：判断一个数是否能表示为 4^k*(8m+7) 的形式。
           - 参数：x - 要判断的数。
           - 返回值：如果 x 可以表示为 4^k*(8m+7) 的形式，则返回 true；否则返回 false。

        时间复杂度：O(sqrt(n))，其中 n 为目标数。需要遍历 sqrt(n) 次。
        空间复杂度：O(1)。
     */
    public static int numSquares2(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (checkAnswer4(n)) {
            return 4;
        }
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    // 判断是否为完全平方数
    public static boolean isPerfectSquare(int x) {
        int y = (int) Math.sqrt(x);
        return y * y == x;
    }

    // 判断是否能表示为 4^k*(8m+7)
    public static boolean checkAnswer4(int x) {
        while (x % 4 == 0) {
            x /= 4;
        }
        return x % 8 == 7;
    }

}
