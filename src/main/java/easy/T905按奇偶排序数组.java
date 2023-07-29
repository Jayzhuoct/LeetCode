package easy;

import java.util.Arrays;

public class T905按奇偶排序数组 {
    public static void main(String[] args) {
        int nums[] = {3, 1, 2, 4};
        int[] ints = sortArrayByParity3(nums);
        System.out.println(Arrays.toString(ints));
    }

    //1.两次遍历，时间复杂度O(n),空间复杂度O(n)
    public static int[] sortArrayByParity1(int[] nums) {
        int[] ans = new int[nums.length];
        int index = 0;
        //先遍历一遍数组，把所有的偶数放到数组前面
        for (int num : nums) {
            if (num % 2 == 0) {
                ans[index++] = num;
            }
        }
        //再遍历一遍数组，把所有的奇数放到数组后面
        for (int num : nums) {
            if (num % 2 == 1) {
                ans[index++] = num;
            }
        }
        return ans;
    }

    //2.原地交换，时间复杂度O(n),空间复杂度O(1)
    /*
    用两个指针 i,j 分别指向数组的首尾，当 i<j 时，执行循环：
    如果 nums[i] 为偶数，则执行 i=i+1 跳过该数字；
    如果 nums[j] 为奇数，则执行 j=j−1 跳过该数字；
    如果 nums[i] 为奇数，nums[j] 为偶数，交换两个数字的位置。
     */
    public static int[] sortArrayByParity2(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            //如果nums[i]是奇数，nums[j]是偶数，交换两个数
            if (nums[i] % 2 == 1 && nums[j] % 2 == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            //如果nums[i]是偶数，i++，如果nums[j]是奇数，j--
            if (nums[i] % 2 == 0) {
                i++;
            }
            if (nums[j] % 2 == 1) {
                j--;
            }
        }
        return nums;
    }

    //3.双指针一次遍历
    /*
    创建一个长度为 n 的新数组 ans，
    然后使用双指针 left 和 right 分别指向新数组的开头和结尾，遍历原数组 nums，
    如果当前元素是偶数，则将其放入新数组的开头位置 ans[left]，并将 left 指针向后移动一位；
    如果当前元素是奇数，则将其放入新数组的结尾位置 ans[right]，并将 right 指针向前移动一位。
    最终，遍历结束后，新数组 ans 中偶数都排在了奇数前面。
    该算法的时间复杂度为 O(n)，其中 n 是原数组的长度。
    由于需要创建一个长度为 n 的新数组，因此空间复杂度也为 O(n)。
     */
    public static int[] sortArrayByParity3(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0, right = n - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                ans[left++] = num;
            } else {
                ans[right--] = num;
            }
        }
        return ans;
    }
}
