package easy;

public class T643子数组最大平均数I {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }

    /*
        时间复杂度为O(N)，其中N是数组nums的长度。代码中有两个循环。
        第一个循环用于计算初始窗口内元素的总和，它的迭代次数为k，所以时间复杂度为O(k)。
        第二个循环从索引k开始，遍历剩余的元素，它的迭代次数为N-k，所以时间复杂度为O(N-k)。
        由于在大O符号表示法中，我们忽略常数项和低阶项，因此总体的时间复杂度为O(N)。

        空间复杂度为O(1)，即常数级别的额外空间。代码中只使用了常数个变量来存储中间结果，
        而不随输入规模N的增加而增加额外的空间。
     */
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0; // 用于存储当前窗口内元素的总和
        int max = 0; // 用于存储当前最大的窗口内元素总和

        // 计算初始窗口内元素的总和
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            max = sum; // 初始情况下，当前窗口内的元素总和即为最大值
        }

        // 遍历数组中剩余的元素，更新窗口内的元素总和和最大值
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            max = Math.max(sum, max); // 更新最大值
        }

        return (double) max / k; // 返回最大平均值
    }
}
