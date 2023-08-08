package easy;

public class T696计数二进制子串 {
    public static void main(String[] args) {
        String s = "00110011";
        System.out.println(countBinarySubstrings1(s));
    }

    /*
    通过遍历字符串并使用一个数组来存储每个连续子串中相同字符的数量。
    然后，它遍历数组，对每一对连续字符的数量取较小值，并将其累加到结果中。
    最后，返回结果作为子串的数量。

    时间复杂度：O(n)
    - 第一个循环遍历字符串并更新计数数组的时间复杂度为 O(n)，其中 n 是字符串的长度。
    - 第二个循环遍历计数数组并计算答案的时间复杂度为 O(n)。

    空间复杂度：O(n)
    - 数组 `arr` 的长度固定为 n，与输入字符串的长度无关。
    - 因此，无论输入字符串的长度如何，所需的额外空间都是常数级别的。
     */
    public static int countBinarySubstrings1(String s) {
        int[] arr = new int[s.length()]; // 创建一个数组，用于存储每个连续子串中相同字符的数量
        int index = 0; // 数组索引
        int count = 1; // 当前连续字符的数量，初始为1，因为至少有一个字符
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) // 如果当前字符与前一个字符相同
                count++; // 增加连续字符的数量
            else {
                arr[index++] = count; // 将当前连续字符的数量存入数组，并将索引后移
                count = 1; // 重置连续字符的数量为1
            }
        }
        arr[index++] = count; // 存储最后一个连续字符的数量

        int res = 0; // 用于存储结果的变量，初始为0
        for (int i = 1; i < index; i++) {
            res += Math.min(arr[i-1], arr[i]); // 对每一对连续字符的数量取较小值，并累加到结果中
        }
        return res; // 返回最终结果
    }

    /*
    通过遍历字符串并使用两个变量来存储前一个连续字符的数量和当前连续字符的数量。
    然后，它比较这两个变量的值，并将较小值累加到结果中。
    最后，返回结果作为子串的数量。
    时间复杂度：O(n)
    - 第一个循环遍历字符串并更新计数数组的时间复杂度为 O(n)，其中 n 是字符串的长度。
    - 第二个循环遍历计数数组并计算答案的时间复杂度为 O(n)。
    空间复杂度：O(1)
    - 只使用了常数级别的额外空间。
     */
    public static int countBinarySubstrings2(String s) {
        int prevCount = 0; // 前一个连续字符的数量
        int currCount = 1; // 当前连续字符的数量
        int res = 0; // 结果变量，初始为0

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                currCount++; // 如果当前字符与前一个字符相同，增加当前连续字符的数量
            } else {
                prevCount = currCount; // 如果当前字符与前一个字符不同，更新前一个连续字符的数量
                currCount = 1; // 重置当前连续字符的数量为1
            }

            // 当前连续字符的数量小于等于前一个连续字符的数量时，说明找到了一个符合条件的子串
            if (currCount <= prevCount) {
                res++; // 增加结果数量
            }
        }

        return res; // 返回最终结果
    }
}
