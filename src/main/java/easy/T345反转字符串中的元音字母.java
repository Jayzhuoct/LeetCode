package easy;

public class T345反转字符串中的元音字母 {
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseVowels(s));

    }
    // 双指针
    /*思路是使用双指针，从字符串的两端开始同时遍历，
    如果当前位置的字符是元音字母，则交换两端的字符，直到两个指针相遇。
    具体来说，函数的参数是一个字符串 s，返回值是一个新的字符串，其中元音字母被反转了。
    函数首先将输入字符串转换成字符数组 chars，
    然后使用两个指针 i 和 j 分别指向字符数组的开头和结尾。
    接下来进入一个 while 循环，只要 i 小于 j，就一直执行循环体。
    在循环体中，首先判断 chars[i] 和 chars[j] 是否都是元音字母，
    如果是，则交换这两个位置的字符，并将 i 和 j 分别向后和向前移动一位。
    如果 chars[i] 不是元音字母，则将 j 向前移动一位，
    如果 chars[j] 不是元音字母，则将 i 向后移动一位。
    最后，如果 chars[i] 和 chars[j] 都不是元音字母，
    则将 i 和 j 分别向后和向前移动一位。
    循环结束后，将字符数组转换成字符串并返回即可。

    时间复杂度：该算法使用了双指针技巧，只需要遍历一遍字符串，因此时间复杂度为 O(n)，其中 n 是字符串的长度。

    空间复杂度：该算法使用了一个字符数组来存储字符串，因此空间复杂度为 O(n)，其中 n 是字符串的长度。
    */
    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length-1;
        while (i<j){
            if (isVowel(chars[i]) && isVowel(chars[j])){
                swap(chars, i, j);
                i++;
                j--;
            }else if (isVowel(chars[i])){
                j--;
            }else if (isVowel(chars[j])){
                i++;
            }else {
                i++;
                j--;
            }
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private static boolean isVowel(char aChar) {
        return aChar == 'a' || aChar == 'e' || aChar == 'i' || aChar == 'o' || aChar == 'u' ||
                aChar == 'A' || aChar == 'E' || aChar == 'I' || aChar == 'O' || aChar == 'U';
    }

}
