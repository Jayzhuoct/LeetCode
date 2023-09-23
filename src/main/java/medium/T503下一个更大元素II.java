package medium;

import java.util.*;

public class T503下一个更大元素II {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    /*
        * 单调栈
        * 时间复杂度：O(n)
        * 空间复杂度：O(n)
     */
    public static int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1); // 默认值为-1
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len * 2 - 1; i++) {
            // 当前元素的索引
            int index = i % len;
            // 如果栈不为空，且栈顶元素小于当前元素，则栈顶元素的下一个更大元素就是当前元素
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                res[stack.pop()] = nums[index];
            }
            // 将当前元素的索引入栈
            stack.push(index);
        }
        return res;
    }
}
