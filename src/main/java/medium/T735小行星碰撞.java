package medium;

import java.util.Deque;
import java.util.LinkedList;

public class T735小行星碰撞 {
    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        int[] res = asteroidCollision(asteroids);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    /*
        使用双端队列作为栈来存储行星。
        遍历给定的行星数组。
        如果当前行星为正向行星，直接入栈。
        如果当前行星为负向行星，不断地将栈顶的正向行星与当前负向行星进行碰撞判断。
        如果栈为空，或者栈顶为负向行星，将当前负向行星入栈。
        如果栈顶的正向行星比当前负向行星小，栈顶的正向行星被当前负向行星摧毁，从栈中移除。
        如果栈顶的正向行星和当前负向行星相等，两者相互抵消，从栈中移除栈顶。
        将栈中的行星转换成数组返回，数组中的行星顺序与栈中的顺序相反。

        时间复杂度：O(n)，其中 n 是给定的行星数组 asteroids 的长度。
        空间复杂度：O(n)。
     */
    public static int[] asteroidCollision(int[] asteroids) {
        // 使用双端队列作为栈来存储行星
        Deque<Integer> stack = new LinkedList<>();

        // 遍历给定的行星数组
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                // 如果当前行星为正向行星，直接入栈
                stack.push(asteroid);
            } else {
                // 如果当前行星为负向行星

                // 不断地将栈顶的正向行星与当前负向行星进行碰撞判断
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                    stack.pop(); // 栈顶的正向行星被当前负向行星摧毁，从栈中移除
                }

                // 栈为空，或者栈顶为负向行星时，将当前负向行星入栈
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }

                // 栈顶与当前负向行星大小相等时，两者相互抵消，从栈中移除栈顶
                else if (stack.peek() == -asteroid) {
                    stack.pop();
                }
            }
        }

        // 将栈中的行星转换成数组返回
        int[] res = new int[stack.size()];
        int i = res.length - 1;
        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }
        return res;
    }
}
