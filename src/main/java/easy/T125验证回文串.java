package easy;

import java.util.ArrayList;

public class T125验证回文串 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome1(s));

    }

    /*
    算法首先创建一个字符列表list，用于存储给定字符串中的字母和数字。
    然后，通过遍历字符串的每个字符，判断字符是否是字母或数字，是的话将其转换为小写并添加到字符列表中。

    接下来，使用两个指针left和right分别指向字符列表的开头和末尾。通过比较左指针和右指针指向的字符，如果它们不相等，则字符串不是回文，返回false。
    如果相等，则将左指针向右移动一位，右指针向左移动一位，继续比较下一对字符，直到左指针大于或等于右指针时退出循环。

    最后，如果循环结束时左指针小于右指针，说明字符串是回文，返回true；否则，返回false。

    时间复杂度：O(n)，其中 n 是字符串的长度。只需要遍历字符串的一半即可，所以时间复杂度是 O(n)。
    空间复杂度：O(n)，其中 n 是字符串的长度。空间复杂度主要取决于字符列表，字符列表的长度为 n。
     */
    public static boolean isPalindrome1(String s) {
        ArrayList<Character> list = new ArrayList<>();  // 创建一个字符列表用于存储字母和数字
        for (char c : s.toCharArray()) {  // 遍历给定字符串的每个字符
            if (Character.isLetterOrDigit(c)) {  // 如果字符是字母或数字
                list.add(Character.toLowerCase(c));  // 将字符转换为小写并添加到字符列表中
            }
        }
        int left = 0, right = list.size() - 1;  // 初始化左右指针，left指向字符列表的开头，right指向末尾
        while (left < right) {  // 当左指针小于右指针时执行循环
            if (list.get(left) != list.get(right)) {  // 如果左指针和右指针指向的字符不相等
                return false;  // 字符串不是回文，返回false
            }
            left++;  // 左指针向右移动
            right--;  // 右指针向左移动
        }
        return true;  // 字符串是回文，返回true
    }

    /*
    算法首先创建一个可变字符串sgood，用于存储给定字符串中的字母和数字。
    然后，通过遍历字符串的每个字符，判断字符是否是字母或数字，是的话将其转换为小写并添加到可变字符串中。
    接下来，将可变字符串sgood进行反转操作，得到另一个可变字符串sgood_rev。
    最后，通过将sgood和sgood_rev转换为不可变字符串，并比较它们是否相等。
    如果相等，则说明字符串是回文，返回true；否则，返回false。

    时间复杂度：O(n)，其中 n 是字符串的长度。只需要对字符串进行一次遍历即可，所以时间复杂度是 O(n)。
    空间复杂度：O(n)，其中 n 是字符串的长度。空间复杂度主要取决于字符串sgood和sgood_rev，两者的长度都是 n。
     */
    public static boolean isPalindrome2(String s) {
        StringBuffer sgood = new StringBuffer();  // 创建一个可变字符串用于存储字母和数字
        int length = s.length();  // 获取字符串的长度
        for (int i = 0; i < length; i++) {  // 遍历字符串的每个字符
            char ch = s.charAt(i);  // 获取当前字符
            if (Character.isLetterOrDigit(ch)) {  // 如果字符是字母或数字
                sgood.append(Character.toLowerCase(ch));  // 将字符转换为小写并添加到可变字符串中
            }
        }
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();  // 将可变字符串反转得到另一个可变字符串
        return sgood.toString().equals(sgood_rev.toString());  // 比较两个可变字符串是否相等，相等则返回true，否则返回false
    }

    /*
    使用双指针的方法，将左指针left和右指针right初始化分别指向字符串的开头和末尾。然后，通过循环来不断缩小指针之间的范围。
    在每次循环中，先移动左指针left，直到指向一个字母或数字。然后，移动右指针right，直到指向一个字母或数字。
    如果左指针小于右指针，表示还有字符需要比较。在这种情况下，比较左指针和右指针指向的字符是否相等，如果不相等，则字符串不是回文，返回false。
    如果左指针和右指针指向的字符相等，继续将左指针向右移动一位，右指针向左移动一位，继续比较下一对字符。
    当左指针大于或等于右指针时，退出循环。此时，表示字符串是回文，返回true。

    时间复杂度：O(n)，其中 n 是字符串的长度。只需要对字符串进行一次遍历即可，所以时间复杂度是 O(n)。
    空间复杂度：O(1)。
     */
    public static boolean isPalindrome3(String s) {
        int n = s.length();  // 获取字符串的长度
        int left = 0, right = n - 1;  // 初始化左右指针，left指向字符串的开头，right指向末尾
        while (left < right) {  // 当左指针小于右指针时执行循环
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;  // 左指针向右移动，直到指向一个字母或数字
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;  // 右指针向左移动，直到指向一个字母或数字
            }
            if (left < right) {  // 如果左指针小于右指针
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;  // 如果左指针和右指针指向的字符不相等，返回false
                }
                ++left;  // 左指针向右移动
                --right;  // 右指针向左移动
            }
        }
        return true;  // 字符串是回文，返回true
    }

}
