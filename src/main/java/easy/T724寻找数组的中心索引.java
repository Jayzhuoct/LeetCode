package easy;

public class T724寻找数组的中心索引 {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
//        int[] nums = {1, 2, 3};
        System.out.println(pivotIndex(nums));
    }

    /*
        间复杂度为O(n)，其中n是数组nums的长度。这是因为代码中包含了两个循环：
        一个循环用于计算数组元素的总和，另一个循环用于遍历数组并查找中心索引。
        这两个循环都是线性循环，其时间复杂度为O(n)。

        空间复杂度是O(1)，即常量空间复杂度。代码中只使用了常量级别的额外空间来存储变量sum和leftSum，
        无论输入数组的规模如何，额外空间的使用量保持不变。因此，空间复杂度为O(1)。
     */
    public static int pivotIndex(int[] nums) {
        int sum = 0; // 总和
        int leftSum = 0; // 左侧和

        // 计算数组所有元素的总和
        for (int num : nums) {
            sum += num;
        }

        // 遍历数组，寻找中心索引
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i; // 找到中心索引
            }
            leftSum += nums[i]; // 更新左侧和
        }

        return -1; // 没有找到中心索引
    }
}
