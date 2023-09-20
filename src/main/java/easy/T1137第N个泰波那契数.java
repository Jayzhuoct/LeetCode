package easy;

public class T1137第N个泰波那契数 {
    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }

    /**
     * 计算第 n 个 Tribonacci 数。
     * 在动态规划中，我们通过将一个大问题分解成更小的子问题，并存储子问题的解，以避免重复计算，并最终得到整个问题的解。
     * 我们使用一个数组 nums 来存储计算过的 Tribonacci 数，以避免重复计算。
     * 代码中的循环部分是动态规划的核心。从第 3 个数开始，每个位置的数都是前三个位置的数之和，
     * 即 nums[i] = nums[i - 3] + nums[i - 2] + nums[i - 1]。
     * 通过逐步计算并存储这些数，我们可以在循环结束后得到第 n 个 Tribonacci 数。
     * 因此利用动态规划的思想，通过存储中间结果来避免重复计算，从而高效地计算 Tribonacci 数列。
     * 时间复杂度：O(n)，其中 n 是斐波那契数的索引。我们需要计算第 n 个斐波那契数，每个斐波那契数都需要 O(1) 的时间。
     * 空间复杂度：O(n)，其中 n 是斐波那契数的索引。我们需要存储计算过的斐波那契数。
     * @param n 计算的斐波那契数的索引
     * @return 第 n 个 Tribonacci 数
     */
    public static int tribonacci(int n) {
        // 如果 n 等于 0，直接返回 0
        if (n == 0) {
            return 0;
        }

        // 创建一个长度为 n+1 的整数数组
        int[] nums = new int[n + 1];
        nums[0] = 0;

        // 如果 n 等于 1，直接返回 1
        if (n == 1) {
            return 1;
        }
        nums[1] = 1;

        // 如果 n 等于 2，直接返回 1
        if (n == 2) {
            return 1;
        }
        nums[2] = 1;

        // 计算第 3 到第 n 个 Tribonacci 数
        for (int i = 3; i <= n; i++) {
            nums[i] = nums[i - 3] + nums[i - 2] + nums[i - 1];
        }

        // 返回第 n 个 Tribonacci 数
        return nums[n];
    }
}
