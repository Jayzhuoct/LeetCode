package medium;

import java.util.Arrays;

public class T1679K和数对的最大数目 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int k = 6;
        System.out.println(maxOperations(nums,k));

    }

    /*
    * 双指针法
    * 1. 对数组进行排序
    * 2. 定义两个指针，分别指向数组的开头和结尾
    * 3. 当两个指针没有相遇时
    *  3.1 如果两个指针指向的元素之和等于目标值k
    *  3.1.1 操作次数加1
    * 3.1.2 左指针向右移动一位
    * 3.1.3 右指针向左移动一位
    * 3.2 如果两个指针指向的元素之和大于目标值k
    * 3.2.1 右指针向左移动一位，减小元素之和
    * 3.3 如果两个指针指向的元素之和小于目标值k
    * 3.3.1 左指针向右移动一位，增大元素之和
    * 4. 返回最大操作次数
    *
    * 时间复杂度：O(nlogn)，其中 n 是数组 nums 的长度。
    * 排序的时间复杂度为 O(nlogn)，双指针遍历的时间复杂度为 O(n)，
    * 因此总时间复杂度为 O(nlogn+n)=O(nlogn)。
    *
    * 空间复制度：O(logn)，排序需要使用 O(logn) 的空间复杂度。
     */
    public static int maxOperations(int[] nums, int k) {
        int max = 0; // 记录最大操作次数
        int len = nums.length; // 数组的长度
        Arrays.sort(nums); // 对数组进行排序，方便后续使用双指针法
        int i = 0, j = len - 1; // 定义两个指针，分别指向数组的开头和结尾

        while (i < j) { // 当两个指针没有相遇时
            if (nums[i] + nums[j] == k) { // 如果两个指针指向的元素之和等于目标值k
                max++; // 操作次数加1
                i++; // 左指针向右移动一位
                j--; // 右指针向左移动一位
            } else if (nums[i] + nums[j] > k) { // 如果两个指针指向的元素之和大于目标值k
                j--; // 右指针向左移动一位，减小元素之和
            } else { // 如果两个指针指向的元素之和小于目标值k
                i++; // 左指针向右移动一位，增大元素之和
            }
        }

        return max; // 返回最大操作次数
    }
}
