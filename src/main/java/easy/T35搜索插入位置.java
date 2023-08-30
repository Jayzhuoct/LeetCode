package easy;

public class T35搜索插入位置 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};// [1,3,5,6], 5
        System.out.println(searchInsert(nums, 5));// 2
        System.out.println(searchInsert(nums, 2));// 1
        System.out.println(searchInsert(nums, 7));// 4
        System.out.println(searchInsert(nums, 0));// 0
    }

    /*
        二分查找
        时间复杂度：O(logn)，其中 n 为数组的长度。二分查找所需的时间复杂度为 O(logn)。
        空间复杂度：O(1)。我们只需要常数空间存放若干的变量。
     */
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;// ans = n 表示 target 大于数组中的所有数
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;// 防止溢出
            if (target <= nums[mid]) {
                ans = mid;// target 小于等于 nums[mid]，则更新 ans = mid
                right = mid - 1;// target 小于等于 nums[mid]，则在 mid 的左侧继续查找
            } else {
                left = mid + 1;// target 大于 nums[mid]，则在 mid 的右侧继续查找
            }
        }
        return ans;
    }
}
