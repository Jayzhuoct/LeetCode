package medium;

public class T215数组中的第K个最大元素 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};;
        System.out.println(findKthLargest(nums, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        // 快速排序
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    // 快速排序算法
    /*
    通过分治的方式将一个大问题分解成多个小问题，然后递归地解决这些小问题。
    在这个实现中，quickSort 方法接收三个参数：
    需要排序的整数数组 nums，以及数组的起始位置 i 和结束位置 j。
    在方法内部，首先判断起始位置是否大于或等于结束位置，如果是则直接返回；
    否则，使用 temp 变量保存当前数组的第一个元素，
    然后使用左右两个指针 left 和 right 分别指向数组的起始位置和结束位置。
    接下来，使用 while 循环来不断移动左右指针，
    使得左侧的元素都小于 temp，右侧的元素都大于 temp，
    并且左指针不断右移，右指针不断左移。当左右指针相遇时，
    将 temp 放到数组中间位置，
    然后递归地对左右两个子数组继续进行快速排序。

    该方法的时间复杂度为 O(n log n)，其中 n 是输入数组的长度。
    这是因为该方法采用的是快速排序算法，其平均时间复杂度为 O(n log n)，
    最坏时间复杂度为 O(n^2)，但是在实际应用中很少出现最坏情况。

    该方法的空间复杂度为 O(log n)，因为快速排序算法是一种递归算法，
    每次递归都需要保存一些辅助信息，因此需要消耗一定的空间。
    但是空间复杂度的实际消耗取决于递归的深度，而快速排序的平均递归深度为 O(log n)，
    因此空间复杂度也是 O(log n)。
     */
    private static void quickSort(int[] nums, int i, int j) {
        // 如果起始位置大于等于结束位置，则返回
        if (i >= j) {
            return;
        }
        // 初始化左右指针、以及随机选择的基准点
        int left = i;
        int right = j;
        int temp = nums[left];
        // 双指针移动
        while (left < right) {
            // 从右向左找到第一个小于基准点的元素
            while (left < right && nums[right] >= temp) {
                right--;
            }
            // 将该元素放到左指针所在位置，并将左指针右移
            if (left < right) {
                nums[left] = nums[right];
            }
            // 从左向右找到第一个大于基准点的元素
            while (left < right && nums[left] <= temp) {
                left++;
            }
            // 将该元素放到右指针所在位置，并将右指针左移
            if (left < right) {
                nums[right] = nums[left];
            }
        }
        // 将基准点放到中间位置
        nums[left] = temp;
        // 递归处理左右两个子数组
        quickSort(nums, i, left - 1);
        quickSort(nums, left + 1, j);
    }

}

