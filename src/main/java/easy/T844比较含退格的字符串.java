package easy;

public class T844比较含退格的字符串 {
    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceCompare1(s, t));
    }

    /*
        时间复杂度：O(M+N)，其中 M 和 N 分别为字符串 S 和 T 的长度。
        空间复杂度：O(M+N)。
     */
    public static boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    // 构建字符串
    private static String build(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                sb.append(c); // 如果字符不是 '#'，则将其追加到 StringBuilder 中
            } else if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1); // 如果字符是 '#'，并且 StringBuilder 不为空，则删除 StringBuilder 中的最后一个字符
            }
        }
        return sb.toString(); // 将 StringBuilder 转换为字符串并返回
    }

    /*
        双指针
        时间复杂度：O(M+N)，其中 M 和 N 分别为字符串 S 和 T 的长度。
        空间复杂度：O(1)。
     */
    public static boolean backspaceCompare1(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1; // i、j 分别指向 s、t 的末尾
        int skipS = 0, skipT = 0; // skipS、skipT 分别记录 s、t 中 '#' 的个数
        while (i >= 0 || j >= 0){
            while (i >= 0) { // 从 s 的末尾开始遍历
                if (s.charAt(i) == '#') { // 如果遇到 '#'
                    skipS++; // 记录 '#' 的个数
                    i--; // 继续遍历 s 的前一个字符
                } else if (skipS > 0) { // 如果当前字符不是 '#'，但是 skipS > 0，说明当前字符需要被删除
                    skipS--; // 删除当前字符
                    i--; // 继续遍历 s 的前一个字符
                } else {
                    break; // 如果当前字符不是 '#'，并且 skipS = 0，说明当前字符不需要被删除，跳出循环
                }
            }
            while (j >= 0){
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0){ // 如果 s 和 t 都还没有遍历完
                if (s.charAt(i) != t.charAt(j)){ // 如果当前字符不相等，返回 false
                    return false;
                }
            } else { // 如果 s 和 t 有一个遍历完了，另一个还没有遍历完
                if (i >= 0 || j >= 0){ // 如果 s 或 t 还有字符没有遍历完，返回 false
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

}
