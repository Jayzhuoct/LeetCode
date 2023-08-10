package easy;

public class T26删除有序数组中的重复项 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));  // 2
        for (int k = 0; k < removeDuplicates(nums); k++) {
            System.out.print(nums[k] + " ");  // 1 2
        }
    }

    /*
    使用双指针的方法，其中指针i用于记录当前非重复元素的位置。
    初始时，i指向数组的第一个元素。然后，使用指针j从第二个元素开始遍历数组。
    当当前元素与前一个元素不相等时，说明找到了一个新的非重复元素，将i向后移动一位，
    并将当前元素放入非重复元素的位置。最后，返回非重复元素的个数，即i的值加1。

    时间复杂度：O(n)，其中n为数组的长度。快指针和慢指针最多各移动n次。
    空间复杂度：O(1)。只需要使用常数的额外空间。
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0;  // 用于记录当前非重复元素的位置
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {  // 当前元素与前一个元素不相等时
                i++;  // 非重复元素的位置向后移动一位
                nums[i] = nums[j];  // 将当前元素放入非重复元素的位置
            }
        }
        return ++i;  // 返回非重复元素的个数
    }
}
