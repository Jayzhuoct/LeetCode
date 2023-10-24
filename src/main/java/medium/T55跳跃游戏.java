package medium;

public class T55跳跃游戏 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};  // true
        int[] nums2 = {3, 2, 1, 0, 4};  // false
        System.out.println(canJump(nums));
        System.out.println(canJump(nums2));
    }

    /*
        时间复杂度：O(n)，其中 n 是数组的大小。只需要访问 nums 数组一遍，共 n 个位置。
        空间复杂度：O(1)，不需要额外的空间开销。
     */
    public static boolean canJump(int[] nums) {
        int max = 0;  // 当前可达到的最远位置
        for (int i = 0; i < nums.length && i <= max; i++) {
            // 遍历数组中的每个位置，同时检查当前位置是否可达
            max = Math.max(max, i + nums[i]);  // 更新可达到的最远位置
        }
        return max >= nums.length - 1;  // 判断是否能够达到最后一个位置
    }
}
