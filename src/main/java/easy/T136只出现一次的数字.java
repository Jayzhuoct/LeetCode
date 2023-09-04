package easy;

public class T136只出现一次的数字 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println(singleNumber(nums));
    }

    /*
        首先，定义一个变量 result 并初始化为 0。该变量将用于存储只出现一次的元素。
        使用 for-each 循环遍历数组 nums 中的每个元素，将当前元素赋值给变量 num。
        在循环中，通过执行异或运算 result ^= num，将 result 与当前元素进行异或操作。
        异或运算的特性是，对于相同的数字进行异或运算结果为 0，对于不同的数字进行异或运算结果为其本身。
        由于其他元素都是成对出现的，只有出现一次的元素会在异或运算中保留下来。
        因此，经过循环遍历后，变量 result 中存储的就是只出现一次的元素。
        最后，返回变量 result 作为结果。
        时间复杂度：O(n)，其中 n 是数组 nums 的长度。只需要对数组遍历一次。
        空间复杂度：O(1)。
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            // 异或运算
            result ^= num;
        }
        return result;
    }
}
