package easy;

public class T70爬楼梯 {
    public static void main(String[] args) {
        System.out.println(climbStairs1(5));
    }

    /*
    动态规划
    通过依次计算每个楼梯的方式数，最终得到爬到第 n 个楼梯的方式数。
    其中，dp[i] 表示爬到第 i 个楼梯的方式数。
    初始情况下，当楼梯数 n 小于等于 2 时，dp[i] 的值就等于 i。
    从第 3 个楼梯开始，每个楼梯的方式数等于前两个楼梯的方式数之和。
    最后返回 dp[n]，即为爬到第 n 个楼梯的方式数。

    时间复杂度：O(n)
    在 for 循环中，需要计算每个楼梯的方式数，因此循环执行了 n-2 次，
    每次操作的时间复杂度是 O(1)。所以总体的时间复杂度是 O(n-2) ≈ O(n)。

    空间复杂度：O(n)
    创建了一个长度为 n+1 的数组 dp，用于保存每个楼梯的方式数，
    因此空间复杂度是 O(n+1) ≈ O(n)。
     */
    public static int climbStairs1(int n) {
        if (n <= 2) {  // 如果 n 小于等于 2，直接返回 n，因为对于 n=1，只有一种爬楼梯的方式；对于 n=2，有两种爬楼梯的方式
            return n;
        }

        int[] dp = new int[n + 1];  // 创建一个长度为 n+1 的数组 dp，用于保存爬到每个楼梯的方式数
        dp[1] = 1;  // 当只有一个楼梯时，只有一种方式
        dp[2] = 2;  // 当有两个楼梯时，有两种方式

        for (int i = 3; i <= n; i++) {  // 从第 3 个楼梯开始，计算每个楼梯的方式数
            dp[i] = dp[i - 1] + dp[i - 2];  // 爬到当前楼梯的方式数等于前两个楼梯的方式数之和
        }

        return dp[n];  // 返回爬到第 n 个楼梯的方式数
    }

    /*
    初始情况下，前两个楼梯的方式数都为 0，而第一个楼梯的方式数为 1。
    然后，通过循环计算每个楼梯的方式数，更新 p、q 和 r 的值。
    在每次循环中，p 和 q 分别更新为前一个楼梯的方式数和当前楼梯的方式数，
    然后 r 更新为 p 和 q 的和，即为当前楼梯的方式数。
    最后返回 r，即为爬到第 n 个楼梯的方式数。

    时间复杂度是 O(n)，空间复杂度是 O(1)。
    由于只使用了三个变量来保存中间结果，所以空间复杂度是常数级别的。
     */
    public static int climbStairs2(int n) {
        int p = 0;  // 前两个楼梯的方式数
        int q = 0;  // 前一个楼梯的方式数
        int r = 1;  // 当前楼梯的方式数

        for (int i = 1; i <= n; ++i) {  // 从第 1 个楼梯开始，依次计算每个楼梯的方式数
            p = q;  // 更新前两个楼梯的方式数为前一个楼梯的方式数
            q = r;  // 更新前一个楼梯的方式数为当前楼梯的方式数
            r = p + q;  // 计算当前楼梯的方式数，等于前两个楼梯的方式数之和
        }

        return r;  // 返回最后一个楼梯的方式数，即为爬到第 n 个楼梯的方式数
    }
}
