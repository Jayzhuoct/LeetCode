package easy;

public class T1470重新排列数组 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 3, 2, 1};
        int n = 4;
        int[] result = shuffle(nums, n);
        for (int i : result) {
            System.out.print(i + " ");
        }

    }

    /*
        时间复杂度：O(n)，其中 n 为数组的长度。需要遍历数组一次。
        空间复杂度：O(1)。只需要创建一个长度为 n 的数组。
     */
    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int index = 0;
        for (int i = 0; i < n; i++) {
            result[index++] = nums[i];
            result[index++] = nums[i + n];
        }
        return result;
    }
}
