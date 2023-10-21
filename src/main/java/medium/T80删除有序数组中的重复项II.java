package medium;

public class T80删除有序数组中的重复项II {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};

        int len = removeDuplicates(nums);
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
            System.out.print(i == len - 1 ? "" : ", ");// 判断是否为最后一个元素
        }
        System.out.print("]");
    }

    /*
        时间复杂度：O(N)，其中 N 是数组的长度。快指针和慢指针最多各移动 N 次。
        空间复杂度：O(1)。只需要使用常数的额外空间。
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0; // 慢指针
        for (int j = 0; j < nums.length; j++) { // 快指针
            if (i < 2 || nums[j] != nums[i - 2]) { // 如果快指针指向的元素不等于val
                nums[i] = nums[j]; // 将快指针指向的元素赋值给慢指针指向的元素
                i++; // 慢指针向后移动一位
            }
        }
        return i; // 返回慢指针的索引
    }
}
