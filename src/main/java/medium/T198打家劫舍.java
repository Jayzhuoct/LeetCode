package medium;

public class T198打家劫舍 {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 9, 3, 1 };
        int maxMoney = rob2(nums);
        System.out.println("最大金额: " + maxMoney);
    }

    /*
        时间复杂度：O(n)
        空间复杂度：O(n)
     */
    public static int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            // 对于第i个房屋，有两种选择：抢劫或不抢劫
            // 如果抢劫第i个房屋，则最大金额为nums[i] + dp[i - 2]
            // 如果不抢劫第i个房屋，则最大金额为dp[i - 1]
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[n - 1];
    }

    /*
        时间复杂度：O(n)
        空间复杂度：O(1)
     */
    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int prevMax = nums[0];             // 前一个房屋的最大金额
        int currMax = Math.max(nums[0], nums[1]);  // 当前房屋的最大金额

        for (int i = 2; i < n; i++) {
            int temp = currMax;             // 临时变量保存当前房屋的最大金额
            currMax = Math.max(nums[i] + prevMax, currMax);  // 更新当前房屋的最大金额
            prevMax = temp;                 // 更新前一个房屋的最大金额
        }

        return currMax;
    }

}
