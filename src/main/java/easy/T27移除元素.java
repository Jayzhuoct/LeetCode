package easy;

public class T27移除元素 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;

        int len = removeElement(nums, val);
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
    public static int removeElement(int[] nums, int val) {
        int i = 0; // 慢指针
        for (int j = 0; j < nums.length; j++) { // 快指针
            if (nums[j] != val) { // 如果快指针指向的元素不等于val
                nums[i] = nums[j]; // 将快指针指向的元素赋值给慢指针指向的元素
                i++; // 慢指针向后移动一位
            }
        }
        return i; // 返回慢指针的索引
    }

}
