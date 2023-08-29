package easy;

public class T746使用最小花费爬楼梯 {
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};// [10,15,20]
        System.out.println(minCostClimbingStairs1(cost));
        System.out.println(minCostClimbingStairs2(cost));
    }

    /*
        * 动态规划
        在函数内部，我们定义了一个整型变量 n，表示楼梯的总数。然后创建了一个长度为 n+1 的整型数组 dp，用于存储每个台阶的最小花费。
        接下来，我们初始化数组 dp 的前两个元素为 0，因为爬到第一个台阶和第二个台阶的花费都是 0。
        然后，我们使用循环从第三个台阶开始计算每个台阶的最小花费。对于每个台阶 i，最小花费等于从前一步或前两步中选择较小的花费，再加上当前步的花费 cost[i-1]。
        最后，函数返回数组 dp 的最后一个元素，即爬完所有楼梯所需的最小花费。
        *
        * 时间复杂度：O(n)，其中 n 是数组 cost 的长度。需要遍历数组一次，计算所有的花费代价。
        * 空间复杂度：O(n)，其中 n 是数组 cost 的长度。需要创建一个长度为 n+1 的数组 dp。
     */
    public static int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            // 当前步数的最小花费等于从前一步或前两步中选择较小的花费，再加上当前步的花费
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }

        return dp[n];
    }

    /*
        优化
        与之前的代码相比，这个实现方式使用了两个变量 prev 和 curr 来追踪前两个阶梯的最小花费和当前阶梯的最小花费。
        在循环中，我们通过比较 curr + cost[i - 1] 和 prev + cost[i - 2] 的值，得到当前步数的最小花费，并将结果存储在变量 next 中。
        然后，我们将 curr 的值更新为 next，将 prev 的值更新为原来的 curr。这样，prev 和 curr 就分别表示前两个阶梯的最小花费和当前阶梯的最小花费。
        最后，函数返回变量 curr，即爬完所有楼梯所需的最小花费。

        时间复杂度：O(n)，其中 n 是数组 cost 的长度。需要遍历数组一次，计算所有的花费代价。
        空间复杂度：O(1)。使用了常数空间。
     */
    public static int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int prev = 0, curr = 0;

        for (int i = 2; i <= n; i++) {
            // 计算当前步数的最小花费，并将结果存储在变量 next 中
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);

            // 更新 prev 和 curr 的值
            prev = curr;
            curr = next;
        }
        return curr;
    }

}
