package easy;

import java.util.*;

public class T496下一个更大元素I {
    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    /*
        * 单调栈
        * 思路：
        * 分解为两个问题：
        * 1. 如何找到 nums2 数组中每个元素的下一个更大元素
        * - 创建一个单调栈，用于存储 nums2 数组中的元素
        * - 从 nums2 数组的末尾开始遍历
        * - 弹出栈顶元素，直到栈为空或者当前元素大于栈顶元素
        * - 将当前元素入栈
        * - 将当前元素作为栈顶元素的下一个更大元素存入哈希表
        * - 将当前元素入栈
        * - 遍历结束后，栈中剩余的元素的下一个更大元素都为 -1
        *
        * 2. 如何根据 nums2 数组中每个元素的下一个更大元素找到 nums1 数组中每个元素的下一个更大元素
        * - 创建一个哈希表，用于存储 nums2 数组中每个元素的下一个更大元素
        * - 遍历 nums1 数组，根据哈希表找到每个元素的下一个更大元素
        *
        * 时间复杂度：O(m+n)
        * 空间复杂度：O(n)
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 创建一个哈希表，用于存储每个元素的下一个更大元素
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 创建一个单调栈
        Deque<Integer> stack = new ArrayDeque<Integer>();

        // 从 nums2 数组的末尾开始遍历
        for (int i = nums2.length - 1; i >= 0; --i) {
            int num = nums2[i];
            // 弹出栈顶元素，直到栈为空或者当前元素大于栈顶元素
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            // 将当前元素作为栈顶元素的下一个更大元素存入哈希表
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            // 将当前元素入栈
            stack.push(num);
        }

        // 创建一个数组用于存储结果
        int[] res = new int[nums1.length];
        // 遍历 nums1 数组，根据哈希表找到每个元素的下一个更大元素
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

}
