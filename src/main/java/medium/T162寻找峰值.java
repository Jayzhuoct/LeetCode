package medium;

public class T162寻找峰值 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement2(nums));
        System.out.println(findPeakElement(nums2));
    }

    /*
        遍历
        时间复杂度：O(n)
        空间复杂度：O(1)
     */
    public static int findPeakElement(int[] nums) {
        int len = nums.length;

        // 处理特殊情况：数组长度为 1
        if (len == 1)
            return 0;

        // 检查第一个元素是否为峰值
        if (nums[0] > nums[1])
            return 0;

        // 检查最后一个元素是否为峰值
        if (nums[len - 1] > nums[len - 2])
            return len - 1;

        // 遍历数组中间的元素，查找峰值
        for (int i = 1; i < len - 1; i++) {

            // 当前元素大于前一个元素和后一个元素时，说明是峰值
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                return i;
        }

        // 数组中不存在峰值元素
        return -1;
    }

    /*
        二分查找
        时间复杂度：O(logn)
        空间复杂度：O(1)
     */
    public static int findPeakElement2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // 检查中间元素是否是峰值
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
