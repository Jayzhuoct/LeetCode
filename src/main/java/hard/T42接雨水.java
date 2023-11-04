package hard;

import java.util.Stack;

public class T42接雨水 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap3(height));

    }

    /*
       动态规划
       1. 找到数组中从下标 i 到最左端最高的条形块高度 left_max。
       2. 找到数组中从下标 i 到最右端最高的条形块高度 right_max。
       3. 扫描数组 height 并更新答案：
          累加 min(max_left[i],max_right[i])−height[i] 到 ans 上
        时间复杂度：O(n)
        空间复杂度：O(n)
     */
    public static int trap(int[] height) {
        int len = height.length;
        if (len == 0) return 0;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        rightMax[len - 1] = height[len - 1];
        // 从左到右计算左边最大值
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        // 从右到左计算右边最大值
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        // 计算结果
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

    /*
        单调栈
        1. 使用栈保存每堵墙。
        2. 当遇到比栈顶墙高的墙时，就可以计算雨水量了。
        3. 雨水量 = 当前墙和栈顶的墙之间的距离 - 栈顶墙的高度。
        4. 计算完，就把当前的墙继续入栈，作为新的栈顶。
        时间复杂度：O(n)
        空间复杂度：O(n)
     */
    public static int trap2(int[] height) {
        int len = height.length;
        if (len == 0) return 0;
        int res = 0;
        int cur = 0;
        Stack<Integer> stack = new Stack<>();
        while (cur < len) {
            // 当前高度大于栈顶高度，可以计算雨水量
            while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
                int top = stack.pop();
                // 栈顶元素出栈后，如果栈为空，说明当前墙之前没有比它高的墙，无法形成坑
                if (stack.isEmpty()) break;
                // 当前墙和栈顶的墙之间的距离
                int distance = cur - stack.peek() - 1;
                // 高度
                int h = Math.min(height[cur], height[stack.peek()]) - height[top];
                res += distance * h;
            }
            stack.push(cur++);
        }
        return res;
    }

    /*
       双指针
        1. 使用双指针，一个指向数组的开头，一个指向数组的结尾。
        2. 使用 left_max 记录左边的最大值，right_max 记录右边的最大值。
        3. 如果 height[left] < height[right]，那么就计算左边的雨水量。
        4. 如果 height[left] >= height[right]，那么就计算右边的雨水量。
        5. 计算完，就把当前的指针对应的值和对应的最大值进行比较，更新最大值。
        6. 指针对应的值比最大值大，就更新最大值；否则，计算雨水量。
        7. 直到两个指针相遇。
        时间复杂度：O(n)
        空间复杂度：O(1)
     */
    public static int trap3(int[] height) {
        int len = height.length;  // 获取数组的长度
        if (len == 0) return 0;  // 如果数组为空，则返回0
        int res = 0;  // 初始化结果变量为0，用于累计储水量
        int left = 0;  // 左指针，指向数组的起始位置
        int right = len - 1;  // 右指针，指向数组的末尾位置
        int leftMax = height[left];  // 初始化左侧最大高度为左指针所指位置的高度
        int rightMax = height[right];  // 初始化右侧最大高度为右指针所指位置的高度
        while (left < right) {  // 当左指针小于右指针时，循环执行以下操作
            if (height[left] < height[right]) {  // 如果左指针所指位置的高度小于右指针所指位置的高度
                if (height[left] >= leftMax) {  // 如果左指针所指位置的高度大于等于左侧最大高度
                    leftMax = height[left];  // 更新左侧最大高度
                } else {
                    res += leftMax - height[left];  // 否则，计算积水量，并累加到结果变量中
                }
                left++;  // 左指针右移一位
            } else {  // 如果右指针所指位置的高度不小于左指针所指位置的高度
                if (height[right] >= rightMax) {  // 如果右指针所指位置的高度大于等于右侧最大高度
                    rightMax = height[right];  // 更新右侧最大高度
                } else {
                    res += rightMax - height[right];  // 否则，计算积水量，并累加到结果变量中
                }
                right--;  // 右指针左移一位
            }
        }
        return res;  // 返回积水量的结果
    }
}
