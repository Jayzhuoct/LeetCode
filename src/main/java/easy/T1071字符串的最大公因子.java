package easy;

public class T1071字符串的最大公因子 {
    public static void main(String[] args) {

    }

    /*
        首先，将 str1 和 str2 连接起来，形成两个拼接后的字符串。
        如果拼接后的字符串不相等，即 (str1 + str2) != (str2 + str1)，则说明没有符合条件的结果，直接返回空字符串 ""。
        如果拼接后的字符串相等，即 (str1 + str2) == (str2 + str1)，则说明存在符合条件的结果。
        接下来，使用辅助函数 gcd 求出 str1.length() 和 str2.length() 的最大公因子。
        最后，通过 str1.substring(0, gcd(str1.length(), str2.length())) 取出 str1 的前缀子串，
        长度为最大公因子的长度，作为最大公因子字符串的结果。

        时间复杂度：函数内部的逻辑主要包括字符串拼接和调用 gcd 函数。
        字符串拼接的时间复杂度为 O(m+n)，其中 m 和 n 分别为 str1 和 str2 的长度。
        gcd 函数的时间复杂度为 O(log(min(m, n)))，其中 m 和 n 分别为 str1 和 str2 的长度。
        因此，总体的时间复杂度为 O(m+n+log(min(m, n)))。

        空间复杂度：函数内部没有使用额外的数据结构，只使用了常数级别的变量空间。因此，空间复杂度为 O(1)。
     */
    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {  // 如果两个字符串不相等，则不存在符合条件的结果
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));  // 返回最大公因子
    }

    /*
        辅助函数 gcd 实现了求两个整数的最大公因子的功能。它使用递归的方式来计算最大公因子。具体逻辑如下：

        如果 b 的值为0，即 b == 0，则返回 a。此时，a 就是最大公因子。
        否则，递归调用 gcd(b, a % b)，将 b 的值作为新的 a，将 a 除以 b 的余数作为新的 b，继续求最大公因子。
     */
    public static int gcd(int a, int b) {  // 求最大公因子的函数
        return b == 0 ? a : gcd(b, a % b);
    }
}
