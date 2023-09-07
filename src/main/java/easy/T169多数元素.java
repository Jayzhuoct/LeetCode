package easy;

public class T169多数元素 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 1, 2};
        System.out.println(majorityElement(nums));
    }

    /*
        int count = 0;：用于记录当前候选元素的计数器，初始值为 0。
        int candidate = 0;：用于记录当前候选元素，初始值为 0。
        for (int num : nums)：遍历给定的整数数组 nums 中的每个元素。
        if (count == 0) candidate = num;：当计数器 count 为 0 时，
        表示当前的候选元素已经被完全抵消，将 num 赋值给 candidate，并将计数器重新置为 1。
        count += (num == candidate) ? 1 : -1;：如果 num 和当前的候选元素 candidate 相等，
        则计数器加 1，表示当前候选元素的出现次数增加；否则计数器减 1，表示当前候选元素的出现次数减少。
        最后，返回候选元素 candidate，即为出现次数超过一半的元素。
        该算法基于摩尔投票算法（Moore's Voting Algorithm），利用了出现次数超过一半的元素的特性，
        通过抵消不同的元素来找到出现次数超过一半的元素。由于出现次数超过一半的元素最终会被保留下来，
        因此该算法可以在一次遍历中找到结果，时间复杂度为 O(n)。
        空间复杂度为 O(1)。
     */
    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0)
                candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
