package medium;

public class T334递增的三元子序列 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(increasingTriplet(nums));
    }

    /*
     * 贪心
     * 维护两个变量 min 和 mid，分别表示当前的最小值和中间值。
     * 遍历数组，如果当前数小于等于最小值，则更新最小值；
     * 如果当前数小于等于中间值，则更新中间值；
     * 如果当前数大于最小值和中间值，则找到了递增的三元组，返回true。
     * 如果遍历完数组仍未找到递增的三元组，则返回false。
     *
     * 时间复杂度：O(n),其中 n 是数组的长度
     * 空间复杂度：O(1),只需要维护两个变量
     */
    public static boolean increasingTriplet(int[] nums) {
        int len = nums.length;

        // 如果数组长度小于3，则无法找到递增的三元组，返回false
        if (len < 3)
            return false;

        int min = Integer.MAX_VALUE; // 当前最小值
        int mid = Integer.MAX_VALUE; // 当前中间值

        // 遍历数组
        for (int num : nums) {
            if (num <= min) {
                // 如果当前数小于等于最小值，更新最小值
                min = num;
            } else if (num <= mid) {
                // 如果当前数小于等于中间值，更新中间值
                mid = num;
            } else {
                // 如果当前数大于最小值和中间值，则找到了递增的三元组，返回true
                return true;
            }
        }

        // 遍历完数组后仍未找到递增的三元组，返回false
        return false;
    }
}
