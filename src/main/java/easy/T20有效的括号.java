package easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

public class T20有效的括号 {
    public static void main(String[] args) {
        String s = "()[]{}";// true
        System.out.println(isValid(s));
        s = "([)]";// false
        System.out.println(isValid(s));
        s = "{[]}";// true
        System.out.println(isValid(s));
        s = "(){}}{";// false
        System.out.println(isValid(s));
    }

    /*
        栈
        时间复杂度：O(n)，其中 n 是字符串 s 的长度。
        空间复杂度：O(n+∣Σ∣)，其中 Σ 表示字符集，本题中字符串只包含 6 种括号，∣Σ∣=6。
        栈中的字符数量为 O(n)，而哈希映射使用的空间为 O(∣Σ∣)，相加即可得到总空间复杂度。
     */
    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {// 奇数个字符，肯定不是有效的括号
            return false;
        }
        Map<Character, Character> pairs = Map.of(')', '(', ']', '[', '}', '{');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {// 右括号
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {// 栈为空或栈顶元素不是对应的左括号
                    return false;
                }
                stack.pop();// 栈顶元素是对应的左括号，出栈
            } else {// 左括号
                stack.push(ch);// 左括号入栈
            }
        }
        return stack.isEmpty();
    }
}
