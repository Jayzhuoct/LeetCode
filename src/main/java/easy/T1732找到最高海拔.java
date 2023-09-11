package easy;

public class T1732找到最高海拔 {
    public static void main(String[] args) {
        int[] gain = {-5, 1, 5, 0, -7};
        System.out.println(largestAltitude(gain));
    }

    /*
        前缀和
        时间复杂度：O(n)，其中 n 是数组 gain 的长度。需要遍历数组 gain 一次。
        空间复杂度：O(1)。
     */
    public static int largestAltitude(int[] gain) {
        int max = 0; // 最大高度初始化为0
        int sum = 0; // 总和初始化为0
        for (int i : gain) { // 遍历数组 gain 中的每个元素
            sum += i; // 将当前元素加到总和中
            max = Math.max(max, sum); // 更新最大高度为当前总和和最大高度的较大值
        }
        return max; // 返回最大高度
    }

}
