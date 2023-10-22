package medium;

public class T189轮转数组 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate3(nums, 3);
        for (int num : nums) {
            System.out.print(num + " ");
        }// 5 6 7 1 2 3 4
    }

    /*
        1. 使用额外的数组
        时间复杂度：O(n)，其中 n 为数组的长度。
        空间复杂度：O(n)。
     */
    public static void rotate(int[] nums, int k) {
        int len = nums.length; // 数组长度
        int[] temp = new int[len]; // 创建一个临时数组，用于存储旋转后的结果
        for (int i = 0; i < len; i++) {
            temp[(i + k) % len] = nums[i]; // 将原数组中的元素按照旋转规则放入临时数组中
        }
        System.arraycopy(temp, 0, nums, 0, len); // 将临时数组中的元素复制回原数组
    }

    /*
        2. 使用环状替换
        时间复杂度：O(n)，其中 n 为数组的长度。
        空间复杂度：O(1)。
     */
    public static void rotate2(int[] nums, int k) {
        int len = nums.length; // 数组长度
        k %= len; // k 可能大于 len，所以取余
        int count = gcd(k, len); // 计算最大公约数
        for (int start = 0; start < count; start++) { // 遍历每个环
            int current = start; // 当前位置
            int prev = nums[start]; // 当前位置的值
            do {
                int next = (current + k) % len; // 下一个位置
                int temp = nums[next]; // 下一个位置的值
                nums[next] = prev; // 将当前位置的值放入下一个位置
                prev = temp; // 将下一个位置的值赋给当前位置
                current = next; // 将下一个位置赋给当前位置
            } while (start != current); // 当回到起始位置时，结束循环
        }
    }

    private static int gcd(int k, int len) {
        return len == 0 ? k : gcd(len, k % len);// 辗转相除法
    }

    /*
        3. 使用反转
        时间复杂度：O(n)，其中 n 为数组的长度。
        空间复杂度：O(1)。
     */
    public static void rotate3(int[] nums, int k) {
        k %= nums.length;// k 可能大于 len，所以取余
        reverse(nums, 0, nums.length - 1);// 先反转整个数组
        reverse(nums, 0, k - 1);// 再反转前 k 个元素
        reverse(nums, k, nums.length - 1);// 最后反转后面的元素
    }
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {// 反转数组
            int temp = nums[start];// 交换元素
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;// 移动指针
            end -= 1;
        }
    }

}
