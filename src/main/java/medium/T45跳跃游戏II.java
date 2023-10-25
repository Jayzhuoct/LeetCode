package medium;

public class T45跳跃游戏II {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};  // 2
        int[] nums2 = {2, 3, 0, 1, 4};  // 2
        System.out.println(jump(nums));
        System.out.println(jump(nums2));
    }

    /*
        时间复杂度：O(n)，其中 n 是数组的大小。只需要访问 nums 数组一遍，共 n 个位置。
        空间复杂度：O(1)，不需要额外的空间开销。
     */
    public static int jump(int[] nums) {
        int max = 0;  // 当前可达到的最远位置
        int end = 0;  // 上次跳跃可达到的最远位置
        int step = 0;  // 跳跃次数
        for (int i = 0; i < nums.length - 1; i++) {
            // 遍历数组中的每个位置，同时检查当前位置是否可达
            max = Math.max(max, i + nums[i]);  // 更新可达到的最远位置
            if (i == end) {  // 遇到上次跳跃可达到的最远位置，更新 end，并增加一次跳跃
                end = max;
                step++;
            }
        }
        return step;
    }
}
