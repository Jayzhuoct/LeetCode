package medium;


import java.util.Arrays;

public class T238除自身以外数组的乘积 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    /*
        * 左 右乘积列表
        *
        * 时间复杂度为 O(n)，其中 n 是数组 nums 的长度。
        * 使用常数空间的话，空间复杂度为 O(1)。
     */
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        // res[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素，所以 res[0] = 1
        res[0] = 1;
        // for (int i = 1; i < len; i++) {
        //     res[i] = nums[i - 1] * res[i - 1];
        // }
        // 优化空间复杂度
        int left = 1;
        for (int i = 1; i < len; i++) {
            left *= nums[i - 1];
            res[i] = left;
        }
        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        // for (int i = len - 1; i >= 0; i--) {
        //     res[i] = res[i] * R;
        //     R *= nums[i];
        // }
        // 优化空间复杂度
        for (int i = len - 1; i >= 0; i--) {
            res[i] *= R;
            R *= nums[i];
        }
        return res;
    }
}
