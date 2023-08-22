package easy;

public class T1920基于排列构建数组 {
    public static void main(String[] args) {
        int[] nums = {0, 2, 1, 5, 3, 4};
        int[] ans = buildArray(nums);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    /*
        时间复杂度O(n)
        空间复杂度O(1)
     */
    public static int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
