package easy;

public class T338比特位计数 {
    public static void main(String[] args) {
        int[] ans = countBits2(5);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    /*
        时间复杂度O(n*logn)
        空间复杂度O(n)
     */
    public static int[] countBits1(int n) {
        int ans[] = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }

    /*
        时间复杂度O(n)
        空间复杂度O(n)
     */
    public static int[] countBits2(int n) {
        int ans[] = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            // 使用位运算计算整数i的二进制表示中1的个数
            // i & (i - 1)可以消去i的二进制表示中最低位的1
            // 因此，ans[i] = ans[i & (i - 1)] + 1，表示ans[i]的值等于ans[i & (i - 1)]的值加1
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }

    /*  动态规划

        初始化一个长度为 n+1 的整数数组 dp，用于存储计算结果。
        对于每个整数 i，我们通过右移操作 i >> 1 得到 i 的二进制表示除去最低位的部分（相当于将 i 的二进制表示向右移动一位）。
        然后，我们通过按位与操作 (i & 1) 来判断 i 的二进制表示的最低位是否为1。
        最后，我们使用动态规划的递推关系 dp[i] = dp[i >> 1] + (i & 1) 来计算 dp[i] 的值，即 dp[i] 的值等于 dp[i >> 1] 的值加上 i 的最低位是否为1的结果。
        返回计算结果数组 dp。

        时间复杂度O(n)
        空间复杂度O(n)
     */
    public static int[] countBits3(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}
