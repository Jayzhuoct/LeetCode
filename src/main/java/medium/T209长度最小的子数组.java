package medium;

import java.util.Arrays;

public class T209长度最小的子数组 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};  // 数组
        int s = 7;  // 目标值
        System.out.println(minSubArrayLen2(s, nums));  // 输出符合条件的最小子数组长度
    }

    /*
      前缀和 + 二分查找
      首先，计算前缀和数组sums，其中sums[i]表示前i个元素的和。然后，遍历数组，对于每个位置i，计算目标值target为s加上前缀和sums[i-1]。
      接下来，使用二分查找在前缀和数组sums中找到目标值target的位置bound。
      如果目标值不存在，获取应该插入的位置。
      最后，如果插入位置bound小于等于数组长度n，则更新最小子数组长度。
      最后返回最小子数组长度，如果没有符合条件的子数组，则返回0。

      时间复杂度：O(nlogn)，其中 n 是数组的长度。
      需要遍历每个下标作为子数组的开始下标，遍历的时间复杂度是 O(n)，
      对于每个开始下标，需要通过二分查找得到长度最小的子数组，二分查找得时间复杂度是 O(logn)

      空间复杂度：O(n)，其中 n 是数组的长度。额外创建数组存储前缀和。

     */
    public static int minSubArrayLen1(int s, int[] nums) {
        int n = nums.length;  // 数组的长度
        if (n == 0) {
            return 0;  // 如果数组为空，直接返回0
        }
        int ans = Integer.MAX_VALUE;  // 最小子数组长度的初始值设为整数的最大值
        int[] sums = new int[n + 1];  // 存储前缀和的数组

        // 计算前缀和数组
        // sums[i] 表示前 i 个元素的和
        // sums[0] = 0 表示前 0 个元素的前缀和为 0
        // sums[1] = nums[0] 表示前 1 个元素的前缀和为 nums[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        // 遍历数组，寻找符合条件的最小子数组长度
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];  // 目标值为 s 加上前缀和
            int bound = Arrays.binarySearch(sums, target);  // 在前缀和数组中二分查找目标值
            if (bound < 0) {
                bound = -bound - 1;  // 如果目标值不存在，获取应该插入的位置
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));  // 更新最小子数组长度
            }
        }

        // 如果最小子数组长度没有被更新过，则返回0，否则返回最小子数组长度
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /*
       滑动窗口
       滑动窗口由左右两个指针构成，初始时窗口为空。
       右指针向右移动扩大窗口，直到窗口内元素的和大于等于目标值。
       然后，左指针向右移动缩小窗口，直到窗口内元素的和小于目标值。
       在这个过程中，不断更新最小子数组长度的值。
       最后返回最小子数组长度，如果没有符合条件的子数组，则返回0。

       时间复杂度：O(n)，其中 n 是数组的长度。指针left、right 最多各移动 n 次。

       空间复杂度：O(1)
     */
    public static int minSubArrayLen2(int target, int[] nums) {
        int left = 0;  // 滑动窗口的左边界
        int right = 0;  // 滑动窗口的右边界
        int sum = 0;  // 当前窗口内元素的和
        int min = Integer.MAX_VALUE;  // 最小子数组长度的初始值设为整数的最大值

        // 使用滑动窗口来搜索符合条件的子数组
        while (right < nums.length) {
            sum += nums[right];  // 将右边界的元素添加到窗口内
            while (sum >= target) {  // 当窗口内元素的和大于等于目标值时
                min = Math.min(min, right - left + 1);  // 更新最小子数组长度
                sum -= nums[left];  // 从窗口内移除左边界的元素
                left++;  // 左边界向右移动
            }
            right++;  // 右边界向右移动，扩大窗口
        }

        // 如果最小子数组长度没有被更新过，则返回0，否则返回最小子数组长度
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
