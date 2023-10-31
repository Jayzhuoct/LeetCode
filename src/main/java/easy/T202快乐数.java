package easy;

import java.util.HashSet;
import java.util.Set;

public class T202快乐数 {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy1(n));
        System.out.println(isHappy2(n));
    }
    /*
        哈希表
        1. 将数字n转换成字符串s
        2. 创建一个哈希表，用于存储每个数字的平方和
        3. 如果哈希表中不存在当前数字的平方和
            1. 将当前数字的平方和存入哈希表
            2. 将当前数字的平方和赋值给n
            3. 将n转换成字符串s
        4. 如果哈希表中存在当前数字的平方和，返回false
        5. 循环结束后，返回true
        时间复杂度：O(logn)
        空间复杂度：O(logn)
     */
    public static boolean isHappy1(int n) {
        // 将数字n转换成字符串s
        String s = String.valueOf(n);
        // 创建一个哈希表，用于存储每个数字的平方和
        Set<Integer> set = new HashSet<>();
        // 如果哈希表中不存在当前数字的平方和
        while (!set.contains(n)) {
            // 将当前数字的平方和存入哈希表
            set.add(n);
            // 将当前数字的平方和赋值给n
            n = 0;
            // 将n转换成字符串s
            for (int i = 0; i < s.length(); i++) {
                n += (s.charAt(i) - '0') * (s.charAt(i) - '0');
            }
            s = String.valueOf(n);
        }
        // 如果哈希表中存在当前数字的平方和，返回false
        return n == 1;
    }

    /*
        快慢指针
        1. 定义两个指针，分别为快指针和慢指针，初始值都为n
        2. 如果快指针不等于1且快指针不等于慢指针
            1. 慢指针移动一步
            2. 快指针移动两步
        3. 循环结束后，如果快指针等于1，返回true；否则返回false
        时间复杂度：O(logn)
        空间复杂度：O(1)
     */
    public static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;  // 获取 n 的个位数
            n = n / 10;  // 去掉 n 的个位数，相当于将 n 右移一位
            totalSum += d * d;  // 将个位数的平方加到总和中
        }
        return totalSum;  // 返回总和
    }

    public static boolean isHappy2(int n) {
        int slowRunner = n;  // 慢指针初始值为 n
        int fastRunner = getNext(n);  // 快指针初始值为 n 的下一个数
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);  // 慢指针移动一步
            fastRunner = getNext(getNext(fastRunner));  // 快指针移动两步
        }
        return fastRunner == 1;  // 如果快指针最终等于 1，说明是快乐数，返回 true；否则返回 false
    }
}
