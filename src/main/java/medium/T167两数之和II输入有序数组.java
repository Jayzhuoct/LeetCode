package medium;

public class T167两数之和II输入有序数组 {
    public static void main(String[] args) {
        int[] numbers = { 2, 7, 11, 15 };
        int target = 9;
        int[] res = twoSum1(numbers, target);
        System.out.println(res[0] + " " + res[1]);
    }

    /*
    双指针
    时间复杂度：O(n)
    - 第一个循环遍历数组的时间复杂度为 O(n)，其中 n 是数组的长度。
    - 第二个循环最多只需要执行 n 次。
    - 因此，总时间复杂度为 O(n)。
    空间复杂度：O(1)
    - 只使用了常数级别的额外空间。
     */
    public static int[] twoSum1(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0, right = numbers.length - 1; // 定义两个指针，分别指向数组的第一个元素和最后一个元素
        while (left < right) { // 当两个指针没有相遇时
            int sum = numbers[left] + numbers[right]; // 计算两个指针指向的两个元素之和
            if (sum == target) { // 如果两个元素之和等于目标值
                res[0] = left + 1; // 将第一个元素的索引赋值给 res[0]
                res[1] = right + 1; // 将第二个元素的索引赋值给 res[1]
                break; // 退出循环
            } else if (sum < target) { // 如果两个元素之和小于目标值
                left++; // 将第一个指针右移一位
            } else { // 如果两个元素之和大于目标值
                right--; // 将第二个指针左移一位
            }
        }
        return res;
    }

    /*
    二分查找
    时间复杂度：O(nlogn)
    空间复杂度：O(1)
     */
    public static int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {  // 如果中间值等于目标值减去当前值
                    return new int[]{i + 1, mid + 1};      // 返回当前索引和中间索引的数组
                } else if (numbers[mid] > target - numbers[i]) {  // 如果中间值大于目标值减去当前值
                    high = mid - 1;                                // 缩小搜索范围至中间值左边部分
                } else {
                    low = mid + 1;                                 // 缩小搜索范围至中间值右边部分
                }
            }
        }
        return new int[]{-1, -1};  // 如果没有找到符合条件的索引对，返回[-1, -1]
    }
}
