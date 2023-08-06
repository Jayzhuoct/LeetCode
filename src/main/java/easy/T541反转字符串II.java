package easy;

public class T541反转字符串II {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s,k));

    }
    // 时间复杂度：O(n)，其中 n 是字符串的长度。需要遍历每个长度为 2k 的子串。
    // 空间复杂度：O(1)。只需要在常数空间内进行变量交换。
    public static String reverseStr(String s, int k) {
        int n = s.length();  // 获取字符串的长度
        char[] arr = s.toCharArray();  // 将字符串转换为字符数组，方便后续操作
        for (int i = 0; i < n; i += 2 * k) {  // 以步长 2k 循环遍历字符串
            int left = i;  // 子串的左边界
            int right = Math.min(i + k - 1, n - 1);  // 子串的右边界（不超过字符串末尾）

            // 反转子串
            while (left < right) {  // 使用两个指针从两端向中间遍历
                char temp = arr[left];  // 临时变量存储左指针指向的字符
                arr[left++] = arr[right];  // 将右指针指向的字符赋值给左指针位置，并将左指针右移
                arr[right--] = temp;  // 将临时变量中的字符赋值给右指针位置，并将右指针左移
            }
        }
        return new String(arr);  // 将字符数组转换为字符串并返回结果
    }
}
