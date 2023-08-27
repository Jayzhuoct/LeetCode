package easy;

import java.util.Arrays;

public class T977有序数组的平方 {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.print(Arrays.toString(sortedSquares(nums)));
    }
    /*
         1.暴力解法
         时间复杂度：O(nlogn)
         空间复杂度：O(logn)
     */
    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);
        return result;
    }

    /*
        2.双指针
        创建一个与输入数组相同长度的结果数组result。
        初始化三个指针：left指向数组的最左端，right指向数组的最右端，index指向结果数组的最后一个位置。
        使用循环，直到left指针超过right指针为止。
        在每次循环中，比较left指针和right指针所指元素的平方值的大小。
        如果left指针所指元素的平方值大于right指针所指元素的平方值，将left指针所指元素的平方值放入结果数组的index位置，并将left指针右移一位。
        否则，将right指针所指元素的平方值放入结果数组的index位置，并将right指针左移一位。
        每次循环结束后，将index指针左移一位。
        循环结束后，返回结果数组result。
        时间复杂度：O(n)
        空间复杂度：O(1)
     */
    public static int[] sortedSquare1(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1, index = nums.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index--] = nums[left] * nums[left]; // 将左侧平方值放入结果数组
                left++;
            } else {
                result[index--] = nums[right] * nums[right]; // 将右侧平方值放入结果数组
                right--;
            }
        }
        return result;
    }

    /*
        3.双指针
        创建一个与输入数组相同长度的结果数组result。
        遍历输入数组，将每个元素平方并更新到原来的位置上。
        找到平方后数组中的最小值的索引，记录为index。
        将最小值放入结果数组的第一个位置。
        初始化两个指针left和right，分别指向index的左边和右边。
        从结果数组的第二个位置开始填充。
        如果left指针和right指针都在有效范围内，比较它们所指的元素大小，将较小的值放入结果数组，并相应地移动指针。
        如果left指针仍在有效范围内，将其所指的元素放入结果数组，并将left指针左移。
        如果right指针仍在有效范围内，将其所指的元素放入结果数组，并将right指针右移。
        循环结束后，返回结果数组result。
        时间复杂度：O(n)
        空间复杂度：O(1)
     */
    public static int[] sortedSquares2(int[] nums) {
        int index = 0;
        int[] result = new int[nums.length];

        // 将数组中的每个元素平方
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        // 找到平方后数组中的最小值的索引
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[index]) {
                index = i;
            }
        }

        // 将最小值放入结果数组的第一个位置
        result[0] = nums[index];

        // 初始化左右指针
        int left = index - 1, right = index + 1;

        // 从结果数组的第二个位置开始填充
        for (int i = 1; i < nums.length; i++) {
            if (left >= 0 && right < nums.length) {
                if (nums[left] < nums[right]) {
                    result[i] = nums[left--]; // 将左指针所指的较小值放入结果数组
                } else {
                    result[i] = nums[right++]; // 将右指针所指的较小值放入结果数组
                }
            } else if (left >= 0) {
                result[i] = nums[left--]; // 左指针还有剩余元素，将其放入结果数组
            } else {
                result[i] = nums[right++]; // 右指针还有剩余元素，将其放入结果数组
            }
        }

        return result;
    }

}
