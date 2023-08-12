package medium;

public class T53最大子序和 {
    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int maxSum = maxSubArray(nums);
        System.out.println("最大子序列和: " + maxSum);
    }

    /*
        * 动态规划
        * 1. 状态定义：dp[i] 表示以 nums[i] 结尾的最大子序列和
        * 2. 状态转移方程：dp[i] = max(nums[i], dp[i - 1] + nums[i])
        * 3. 初始状态：dp[0] = nums[0]
        * 4. 返回值：max(dp[0], dp[1], ..., dp[n - 1])
        * 时间复杂度：O(n)
        * 空间复杂度：O(1)
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int currentSum = nums[0]; // 当前子序列的和
        int maxSum = nums[0]; // 最大子序列和

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]); // 判断是将当前元素加入子序列，还是以当前元素作为新的子序列的开始
            maxSum = Math.max(maxSum, currentSum); // 更新最大子序列和
        }

        return maxSum;
    }
}
