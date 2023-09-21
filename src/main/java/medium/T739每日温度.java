package medium;

public class T739每日温度 {
    public static void main(String[] args) {
        int [] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int [] res = dailyTemperatures(temperatures);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    /*
        单调栈
        时间复杂度：O(n)
        空间复杂度：O(n)
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        // 单调栈
        int[] stack = new int[temperatures.length];
        // 栈顶指针
        int top = -1;
        for (int i = 0; i < temperatures.length; i++) {
            // 当前温度大于栈顶温度
            while (top != -1 && temperatures[i] > temperatures[stack[top]]) {
                // 栈顶元素出栈
                int prevIndex = stack[top--];
                // 计算栈顶元素的下一个更大元素的索引差值
                res[prevIndex] = i - prevIndex;
            }
            // 当前元素入栈
            stack[++top] = i;
        }
        return res;
    }
}
