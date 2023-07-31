package easy;

import java.util.Arrays;

public class T283移动零 {
    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 3, 12};
        new T283移动零().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }

    /*用两个指针 i 和 j，其中指针 i 指向已经处理好的非零元素的末尾，
    指针 j 指向当前正在处理的元素。
    具体来说，我们从数组的开头开始遍历，如果当前元素不是零，我们就将它移动到指针 i 指向的位置，
    并将指针 i 向前移动一位。如果当前元素是零，我们就不做任何操作，继续向前移动指针 j。
    最终，所有的非零元素都被移动到了数组的开头，而数组的末尾都是零元素。
    时间复杂度是 O(n)，其中 n 是数组 nums 的长度，因为我们只遍历了一次整个数组，并且在每个位置上只进行了常数次操作。
    空间复杂度是 O(1)，因为我们只使用了常数个额外的变量。*/
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                if (i != j) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
                i++;
            }
            j++;
        }
    }
}
