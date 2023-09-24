package medium;

import java.util.LinkedList;

public class T394字符串解码 {
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(decodeString(s));
    }

    /*
        * 栈
        *
        * 时间复杂度为 O(n)，其中 n 是字符串 s 的长度，
        * 因为需要遍历字符串中的每个字符一次。
        *
        * 空间复杂度为 O(m)，其中 m 是编码后字符串中的子串数量，
        * 因为需要使用两个栈来存放数字和字符串。
     */
    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        // 存放数字的栈
        LinkedList<Integer> stack_multi = new LinkedList<>();
        // 存放字符串的栈
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            // 如果是数字
            if (c >= '0' && c <= '9') {
                // 计算数字
                multi = multi * 10 + Integer.parseInt(c + "");
            } else if (c == '[') {
                // 将数字入栈
                stack_multi.addLast(multi);
                // 将字符串入栈
                stack_res.addLast(res.toString());
                // 重置
                res = new StringBuilder();
                multi = 0;
            } else if (c == ']') {
                // 取出数字
                int cur_multi = stack_multi.removeLast();
                // 取出字符串
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                // 将字符串拼接到前一个字符串后面
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else {
                // 如果是字母
                res.append(c);
            }
        }
        return res.toString();
    }
}
